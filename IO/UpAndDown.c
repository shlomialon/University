#include <stdio.h>
#include <stdlib.h>
#include <semaphore.h>
#include <pthread.h>
#define N 5
#define CYCLES 3

typedef struct _args {
	int id;
	sem_t *semIncreasing, *semDecreasing;
} arg_t;

void* upDownThread(void* args) {
	arg_t* arg = (arg_t*)args;
	int id = arg->id;
	sem_t* inc = arg->semIncreasing, *dec = arg->semDecreasing;
	int i;
	for (i = 0; i < CYCLES; i++) {
		sem_wait(&inc[id]);
		printf("%d\n", id + 1);
		if (id < N - 1) sem_post(&inc[id + 1]);
		else sem_post(&dec[id]);
		sem_wait(&dec[id]);
		printf("%d\n", id + 1);
		if (id > 0) sem_post(&dec[id - 1]);
		else sem_post(&inc[id]);
	}
	pthread_exit(0);
}

int main() {
	sem_t* semIncreasing = (sem_t*)malloc(N*sizeof(sem_t));
	sem_t* semDecreasing = (sem_t*)malloc(N*sizeof(sem_t));
	pthread_t* threads = (pthread_t*)malloc(N*sizeof(pthread_t));
	arg_t* args = (arg_t*)malloc(N*sizeof(arg_t));
	int i;
	for (i = 0; i < N; i++) {
		sem_init(&(semIncreasing[i]), 0, i == 0 ? 1 : 0);
		sem_init(&(semDecreasing[i]), 0, 0);
	}
	for (i = 0; i < N; i++) {
		args[i].id = i, args[i].semIncreasing = semIncreasing, args[i].semDecreasing = semDecreasing;
		pthread_create(&threads[i], 0, upDownThread, &args[i]);
	}
	for (i = 0; i < N; i++) {
		pthread_join(threads[i], 0);
	}
	free(args);
	free(semIncreasing);
	free(semDecreasing);
	free(threads);
	return 0;
}
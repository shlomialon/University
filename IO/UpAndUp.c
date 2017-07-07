#include <stdio.h>
#include <stdlib.h>
#include <semaphore.h>
#include <pthread.h>
#define N 5
#define CYCLES 100

typedef struct _args {
	int id;
	int* coins;
	sem_t *sem;
} arg_t;

void* printThread(void* args) {
	arg_t* arg = (arg_t*)args;
	int id = arg->id;
	sem_t* sem = arg->sem;
	int* coins = arg->coins;
	int i, count = 0;
	for (i = 0; i < CYCLES; i++) {
		sem_wait(&sem[id]);
		if (coins[id] > 0) {
			printf("%d\n", id);
			count++;
			coins[id]--;
			if (coins[id] == 0) {
				coins[(id + 1) % N] = count + 1;
				count = 0;
			}
		}
		sem_post(&sem[(id + 1) % N]);
	}
	pthread_exit(0);
}

int main() {
	sem_t* sem = (sem_t*)malloc(N*sizeof(sem_t));
	int* coins = (int*)malloc(N*sizeof(int));
	pthread_t* threads = (pthread_t*)malloc(N*sizeof(pthread_t));
	arg_t* args = (arg_t*)malloc(N*sizeof(arg_t));
	int i;
	for (i = 0; i < N; i++) {
		sem_init(&(sem[i]), 0, i == 0 ? 1 : 0);
		coins[i] = i == 0 ? 1 : 0;
	}
	for (i = 0; i < N; i++) {
		args[i].id = i, args[i].coins = coins, args[i].sem = sem;
		pthread_create(&threads[i], 0, printThread, &args[i]);
	}
	for (i = 0; i < N; i++) {
		pthread_join(threads[i], 0);
	}
	free(args);
	free(sem);
	free(coins);
	free(threads);
	return 0;
}
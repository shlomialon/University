#include <stdio.h>
#include <stdlib.h>
#include <semaphore.h>
#include <pthread.h>
#define N 5
#define LEFT (i-1) % N
#define RIGHT (i+1) % N
#define THINKING 0
#define HUNGRY 1
#define EATING 2 
#define NUM_OF_ROUNDS 10

int state[N];
pthread_mutex_t mutex;
sem_t forks[N];
int id[N];

void think(int i) {
	state[i] = THINKING;
}

void test(int i) {
	if (state[i] == HUNGRY && state[LEFT] != EATING && state[RIGHT] != EATING) {
		state[i] = EATING;
		sem_post(&forks[i]);
	}
}

void pick_sticks(int i) {
	pthread_mutex_lock(&mutex);
	state[i] = HUNGRY;
	test(i);
	pthread_mutex_unlock(&mutex);
	sem_wait(&forks[i]);
}

void put_sticks(int i) {
	pthread_mutex_lock(&mutex);
	state[i] = THINKING;
	printf("philosopher %d thinking\n", i);
	test(LEFT);
	test(RIGHT);
	pthread_mutex_unlock(&mutex);
}

void eat(int i) {
	state[i] = EATING;
	printf("philosopher %d eating\n", i);
}

void* philosopher(void* args) {
	int id = *((int*)args);
	int i;
	for (i = 0; i < NUM_OF_ROUNDS; i++) {
		think(id);
		pick_sticks(id);
		eat(id);
		put_sticks(id);
	}
	pthread_exit(0);
}

int main() {
	pthread_mutex_init(&mutex, NULL);
	int i;
	for (i = 0; i < N; i++) {
		sem_init(&forks[i], 0, 0);
		id[i] = i;
	}
	pthread_t philosophers[N];
	for (i = 0; i < N; i++) {
		pthread_create(&philosophers[i], 0, philosopher, &id[i]);
	}
	pthread_exit(0);
	return 0;
}
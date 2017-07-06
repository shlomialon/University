#include <stdio.h>
#include <stdlib.h>
#include <semaphore.h>
#include <pthread.h>
#define SIZE 5 // buffer size
#define NUM_OF_ITEMS 500

typedef int Item;

Item buffer[SIZE];
int buf_first_index = 0, buf_last_index = 0, item_id = 0;
pthread_mutex_t mutex;
sem_t empty;
sem_t full;

void produce_item(Item* item) {
	*item = item_id++;
	printf("produce: %d\n", *item);
}

void enter_item(Item* item) {
	buffer[buf_last_index] = *item;
	buf_last_index = (buf_last_index + 1) % SIZE;
}

void remove_item(Item* item) {
	*item = buffer[buf_first_index];
	buf_first_index = (buf_first_index + 1) % SIZE;
}

void consume_item(Item* item) {
	printf("consume: %d\n", *item);
}

void* producer(void* args) {
	int i;
	int item;
	for (i = 0; i < NUM_OF_ITEMS; i++) {
		produce_item(&item);
		sem_wait(&empty);
		pthread_mutex_lock(&mutex);
		enter_item(&item);
		pthread_mutex_unlock(&mutex);
		sem_post(&full);
	}
	pthread_exit(0);
}

void* consumer(void* args) {
	int i;
	int item;
	for (i = 0; i < NUM_OF_ITEMS; i++) {
		sem_wait(&full);
		pthread_mutex_lock(&mutex);
		remove_item(&item);
		pthread_mutex_unlock(&mutex);
		sem_post(&empty);
		consume_item(&item);
	}
	pthread_exit(0);
}

int main() {
	pthread_mutex_init(&mutex, NULL);
	sem_init(&(empty), 0, SIZE);
	sem_init(&(full), 0, 0);
	pthread_t prod, cons;
	pthread_create(&prod, 0, producer, 0);
	pthread_create(&cons, 0, consumer, 0);
	pthread_exit(0);
	return 0;
}
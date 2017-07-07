#include <stdio.h>
#include <stdlib.h>
#include <semaphore.h>
#include <pthread.h>
#define VEHICLES 100 // buffer size
#define NUM_OF_ROUNDS 1

int count[] = {0, 0};
pthread_mutex_t waiting[2];
pthread_mutex_t mutex, busy;

void arrive(int direction){
    pthread_mutex_lock(&waiting[direction]);
    pthread_mutex_lock(&mutex);
    count[direction] += 1;
    if (count[direction] == 1){
        pthread_mutex_unlock(&mutex);
        pthread_mutex_lock(&busy);
    } 
    else {
        pthread_mutex_unlock(&mutex);
    }
    pthread_mutex_unlock(&waiting[direction]);
}

void leave(int direction){
    pthread_mutex_lock(&mutex);
    count[direction] -= 1;
    if (count[direction] == 0){
        pthread_mutex_unlock(&busy);
    }
    pthread_mutex_unlock(&mutex); 
}

int id_count = 0;
void* vehicle1(void* args) {
    pthread_mutex_lock(&mutex);
    int id = id_count++;
    pthread_mutex_unlock(&mutex); 
    int i;
    for (i = 0; i < NUM_OF_ROUNDS; i++) {
        printf("%d arrive from direction 0\n",id);
        arrive(0);
        printf("%d in the tunnel\n",id);
        leave(0);
        printf("%d leave from direction 0\n",id);
    }
    pthread_exit(0);
} 

void* vehicle2(void* args) {
    pthread_mutex_lock(&mutex);
    int id = id_count++;
    pthread_mutex_unlock(&mutex); 
    int i;
    for (i = 0; i < NUM_OF_ROUNDS; i++) {
        printf("%d arrive from direction 1\n",id);
        arrive(1);
        printf("%d in the tunnel\n",id);
        leave(1);
        printf("%d leave from direction 1\n",id);
    }
    pthread_exit(0);
} 

int main() {
    pthread_mutex_init(&mutex, NULL);
    pthread_mutex_init(&busy, NULL);
    pthread_mutex_init(&waiting[0], NULL);
    pthread_mutex_init(&waiting[1], NULL);
    pthread_t vehicles1[VEHICLES];
    pthread_t vehicles2[VEHICLES];
    int i;
    for (i = 0; i < VEHICLES; i++) {
        pthread_create(&vehicles1[i], 0, vehicle1, 0);
        pthread_create(&vehicles2[i], 0, vehicle2, 0);
    }
    pthread_exit(0);
    return 0;
}
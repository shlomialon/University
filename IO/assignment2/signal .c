#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <signal.h>
#include <string.h>

#define SIGOK 10

typedef union sigval sigval_t;

static pid_t offspring[200];
static int lastChild = 0;
static int sigok_gotten = 0;
static sigset_t mask, oldmask;
static int RECVD_OKS = 0;

pid_t createProcess (void (*F) (void) );

int sendSignal() ;

void recv_from_child_handler(int i) ;

void wait_for_sigok() ;

void info_handler(int sig, siginfo_t *si, void *ucontext);

void printChilds();

void printHello();


int main() {

    struct sigaction act;
    act.sa_sigaction = info_handler;
    sigemptyset(&act.sa_mask);
    act.sa_flags = SA_SIGINFO;
    sigaction(SIGOK, &act, 0);

    pid_t id;

    /* Set up the mask of signals to temporarily block. */
    sigemptyset (&mask);
    sigaddset (&mask, SIGOK);
    
    id = createProcess(&printHello);
    if(id != 0) {
      id = createProcess(&printHello);
      if(id != 0) {
            printChilds();
            printf("created children , now sending signals \n");
            sendSignal();
      }
    }
    return 0;
}

pid_t createProcess (void (*F) (void) ) {
    pid_t id = fork();
    offspring[lastChild] = id;
    lastChild++;
    if(id == 0) {
        // if(kill(getppid(), SIGABRT) < 0 ){
        //     perror("could not kill parent process");
        //     exit(1);
        // }
        lastChild = 0;
        RECVD_OKS = 0;
        F();
    }
    return id;
}

void printChilds() {
    int i;
    printf("[ ");
    for(i=0; i<lastChild;i++) {
        printf("%i, ", offspring[i]);
    }
    printf(" ]\n");
    return;
}

int sendSignal() {
    int i;
    
    // val to send to children
    sigval_t val;
    char* msg = "from_dad";
    val.sival_ptr = msg;
    
    for(i = 0; i < lastChild; i++) {
        printf("SIGOK sent: dad[%d] -> child[%d] \n", getpid(),offspring[i] );
        sigqueue(offspring[i],SIGOK,val);
        wait_for_sigok();
    }

    return 1;
}

void info_handler(int sig, siginfo_t *si, void *ucontext){
    sigval_t val;
    char* from_child_msg = "from_child";
    val.sival_ptr = from_child_msg;
    pid_t sender = si->si_pid;
    char* msg = (char*)si->si_value.sival_ptr; 

    // printf("info handler [PID:%d]: sig: %d ,recved from: %d , message: %s\n",getpid(), sig, sender, msg);
    if(strcmp(msg,"from_dad") == 0) {
        // printf("received OK from dad, passing OK to all offspring... \n");
        printf("SIGOK received: dad[%d] -> child[%d] \n", sender, getpid());

        int sentToAllChildren = sendSignal();
        if(sentToAllChildren == 1) {
            // printf("Done sending OK to offspring, sending OK to dad... \n");
            printf("SIGOK sent: child[%d] -> dad[%d] \n", getpid(), getppid());
            sigqueue(getppid(),SIGOK,val);
        }
    }
    else {
        sigok_gotten = 1;
        RECVD_OKS++;
        printf("SIGOK received: child[%d] -> dad[%d] \n", sender, getpid());
        return;
    }

}

void wait_for_sigok() {
    /* Wait for a signal to arrive. dont forget to set sigok_gotten to false */
    sigprocmask (SIG_BLOCK, &mask, &oldmask);
    while (!sigok_gotten) {
        sigsuspend(&oldmask);
    }
    sigok_gotten = 0;
    sigprocmask (SIG_UNBLOCK, &mask, NULL);
}

void printHello() {
    // printf("new process executing F\n");
    while(1){}
}
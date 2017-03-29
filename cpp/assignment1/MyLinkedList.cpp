
#include "MyLinkedList.hpp"

MyLinkedList::MyLinkedList(){
    this->head = NULL;
    this->tail = NULL;
    size = 0;
}

MyLinkedList::MyLinkedList(string *strArr, double *doubleArr, size_t len){
    for (int i = 0; i < len; i++) {
      add(strArr[i],doubleArr[i]);
    }
}

void MyLinkedList:: add(string key, double data){
    Node* newNode = new Node(key,data);
    if(head == NULL){
        head = newNode;
        tail = head;
        size++;
    }else{
        Node* tmp = tail;
        tail = newNode;
        tail->prev = tmp;
        tmp->next = tail;
        size++;
    }
}


 string MyLinkedList::toString(){
        string ans;
        Node* curr = head;
        while(curr->next != NULL){
            ans +=  curr->getKey() + "," + std::to_string(curr->getData()) + " -> " ;
            curr = curr->next;
        }
        ans += curr->getKey();
        
        return ans;
    }


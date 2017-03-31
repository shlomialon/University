
#include "MyLinkedList.hpp"

MyLinkedList::MyLinkedList(){
    this->head = NULL;
    this->tail = NULL;
    size = 0;
}

MyLinkedList::MyLinkedList(std::string *strArr, double *doubleArr, size_t len){
    for (int i = 0; i < len; i++) {
      add(strArr[i],doubleArr[i]);
    }
}

MyLinkedList::MyLinkedList(MyLinkedList* list){
    list->head = head;
    list->tail = tail;
}

MyLinkedList::~MyLinkedList(){
    Node* temp;
while (head != NULL){
    temp = head->next;
    delete head;
    head = temp;
  }
}

void MyLinkedList:: add(std::string key, double data){
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

void MyLinkedList::remove(std::string s){
     Node* curr = head;
    while(curr != NULL){
        if(curr->getKey() == s){
            (curr->prev)->next = curr->next;
            (curr->next)->prev = curr->prev;
            size--;
        }
        curr = curr->next;
    }
}

double MyLinkedList::sumList(){
    double sumListAns = 0;
    Node* curr = head;
    while(curr != NULL){
        sumListAns += curr->getData();
        curr = curr->next;
    }
    return sumListAns;
}

bool MyLinkedList::isInList(std::string key,double data){
    Node* curr = head;
    while(curr != NULL){
        if(key == curr->getKey() && data == curr->getData()){
            return true;
        }else{
         curr = curr->next;   
        }
    }
    return false;
}

int MyLinkedList::sizelist(){
    return this->size;
}

 std::string MyLinkedList::toString(){
        std::string ans;
        Node* curr = head;
        while(curr->next != NULL){
            //ans +=  curr->getKey() + "," + std::to_string(curr->getData()) + " -> " ;
            curr = curr->next;
        }
        ans += curr->getKey();
        return ans;
    }


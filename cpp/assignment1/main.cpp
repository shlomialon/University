
#include <iostream>
using namespace std;
#include "MyLinkedList.cpp"
#include <sstream>
#include <string>


int main(){
    Node* n = new Node("shlomi",23.0);
    n->toString();
    
    MyLinkedList* list = new MyLinkedList();
    list->add("shlomi",23.0);
    list->add("elad",20.0);
    list->add("linoy",24.0);
    list->add("shahar",29.5);
    
    cout << list->toString();
};
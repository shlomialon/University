#include <stdio.h>
#include <stdlib.h>
#include "List.h"

struct _node{
	double _data;
	struct _node *_next;  
}typedef Node;

Node* Node_alloc(Node *next, double data){
	Node *p = (Node*)malloc(sizeof(Node));
	p-> _data = data;
	(*p)._next = next;
}

void Node_free(Node *node){
	free(node);
}

struct _List{
	Node *_head;
	size_t _size;
}typedef List;

List *List_alloc(){
	List *p = (List*)malloc(sizeof(List));
	p->_head = NULL;
	p->_size = 0;
return p;
}

void List_free(List *list){
	if(list == NULL)return;
	Node *p = list->_head;
	Node *deleteNode;
	
	while(p){
		deleteNode = p;
		p = p->_next;
		free(deleteNode);
	}
	free(list);
}

size_t List_size(const List *list){
	return list->_size;
}

double List_firstData(const List *list){
	return list->_head->_data;
}

void List_insertFirst(List *list, double data){
	list->_head = Node_alloc(list->_head,data);
	(list->_size)++;
}

void List_print(const List* list) {
	const Node* p= list->_head;
	while(p) {
		printf("(%.2f)->",p->_data);
		p= p->_next;
	}
	printf("|| size:%zu\n",list->_size);
}

int List_equal(const List* list1, const List* list2) {
const int equal = 0;
const int notEqual = 1;

Node *p1 = list1->_head;
Node *p2 = list2->_head;

while(p1){
	if(p2 == NULL || p1->_data != p2->_data)
		return notEqual;
	p1 = p1->_next;
	p2 = p2->_next;
}
	if(p2 != NULL)return notEqual;
return equal;
}

List* List_clone(const List* list) {
	List* ret= List_alloc();
	const Node* old= list->_head;
	Node** copy= &(ret->_head);
	ret->_size= list->_size;
	while(old) {
		*copy= Node_alloc(NULL,old->_data);
		old= old->_next;
		copy= &((*copy)->_next);
	}
	return ret;
}

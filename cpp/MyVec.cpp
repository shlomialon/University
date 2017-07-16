#include <iostream>
#include <vector>

using namespace std;

template<class T>
class MyVec {
private:
	size_t DEFAULT_SIZE = 10;
	vector<T> *vec;
	size_t size;

public:
	MyVec() {
		vec = new vector<T>(0);
		size = 0;
	}


	void insert(T item) {
		vec->push_back(item);
		size++;
		cout << vec->size() << endl;
	}

	class Iterator {
	private:
		vector<T> *vec;
		size_t index;
		size_t size;

	public:
		Iterator(vector<T> *vec) {
			index = 0;
			size = vec->size();
		}
		~Iterator() {
			if (vec) free(vec);
		}

		Iterator(size_t index, vector<T> *vec) {
			this->index = index;
			size = vec->size();
		}

		Iterator& operator++() {
			this->index++;
			return *this;
		}

		bool operator==(const Iterator &rhs) const {
			return vec == rhs.vec &&
				index == rhs.index;
		}

		bool operator!=(const Iterator &rhs) const {
			return !(rhs == *this);
		}

		T get() {
			return vec->at(index);
		}
		T next() {
			return vec->at(index++);
		}
	};

	Iterator begin() {
		return Iterator(vec);
	}

	Iterator end() {
		return Iterator(vec->size(), vec);
	}
};


int main() {
	MyVec<int> vec;
	vec.insert(1); vec.insert(2); vec.insert(3);
	MyVec<int>::Iterator it = vec.begin();
	while (it != vec.end()) {
		int val = it.get();
		cout << val << endl;
		++it;
	}
	return 0;
}
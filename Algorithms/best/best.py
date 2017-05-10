import numpy as np
import datetime
class Test:

    n = 4

    def random_arr(self):
        return np.random.rand(4, 1)

    def  best_Build_Matrix(self, arr):
        matrix = np.zeros((len(arr), len(arr)), dtype='int32')

        for i in range(0, len(arr)):
            matrix[i][i] = arr[i]
        for i in range(0, len(arr)):
            for j in range(i+1, len(arr)):
                matrix[i][j] = matrix[i][j-1] + arr[j]
        return matrix

    def  best_Build_Matrix_Swich_Indexs(self, arr):
        matrix = np.zeros((len(arr), len(arr)), dtype='int32')
        for i in range(0, len(arr)):
            matrix[i][i] = arr[i]
        for i in range(0, len(arr)):
            for j in range(i+1, len(arr)):
                matrix[i][j] = matrix[i+1][j] + arr[i]
        return matrix


    def main(self):
        start = datetime.datetime.now()
        for x in range(0, 1000000):
            self.best_Build_Matrix(self.random_arr())
        end = datetime.datetime.now()
        print "matrix[i][j] = matrix[i][j-1] + arr[j]: ", end-start

        start = datetime.datetime.now()
        for x in range(0, 1000000):
            self.best_Build_Matrix_Swich_Indexs(self.random_arr())
        end = datetime.datetime.now()
        print "matrix[i][j] = matrix[i+1][j] + arr[i] " , end-start

def main():
    test = Test()
    test.main()



main()

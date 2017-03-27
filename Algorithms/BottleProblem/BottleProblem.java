/**
 * Created by Shlomi Alon on 27/03/2017.
 */
public class BottleProblem {

    private final int _infinity = 0;
    private int _m,_n, _dim, _mat[][];
    public BottleProblem(int m, int n){
        _m = m;  // big bottle
        _n = n;	 // small bottle
        _dim = (_m+1)*(_n+1); // matrix dimension
        _mat = new int[_dim][_dim];
        for (int i=0;i<_dim;i++){
            for (int j=0;j<_dim;j++){
                _mat[i][j]=_infinity;
            }
        }
    }
    // the matrix initialization
    private void initMatrBottle(){
        for (int i = 0; i < _m ; i++) {
            for (int j = 0; j < _n; j++) {
                int indij = index(i,j);
                _mat[indij][index(i,0)] = 1;
                _mat[indij][index(0,j)] = 1;
                _mat[indij][index(i,_n)] = 1;
                _mat[indij][index(_m,j)] = 1;
                int indMinMax=index(Math.max(0,i+j-_n),Math.min(_n,i+j));
                _mat[indij][indMinMax]=1;
                indMinMax = index(Math.min(_m,i+j),Math.max(0,j+i-_m));
                _mat[indij][indMinMax]=1;
            }
        }

        for (int i = 0; i < _mat.length ; i++) {
            for (int j = 0; j < _mat[0].length; j++) {
                System.out.print("," + _mat[i][j]);
            }
            System.out.println();
        }
    }

    private int index(int i,int j){
        return (_n+1)*i + j;
    }
    public static void main(String[] args) {
        BottleProblem bp = new BottleProblem(2, 1);
        bp.initMatrBottle();

    }
}

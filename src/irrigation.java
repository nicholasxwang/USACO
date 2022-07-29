import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


class Vertex {
    private String id;
    private int value;
    private Vertex parent;
    private ArrayList<Vertex> listAdj;

    public Vertex(String id, int value, Vertex parent){
        this.id = id;
        this.value = value;
        this.parent = parent;
        this.listAdj = new ArrayList<Vertex>();
    }

    public String getId(){return this.id;}
    public int getValue(){return this.value;}
    public Vertex getParent(){return this.parent;}
    public ArrayList<Vertex> getListAdj(){return this.listAdj;}

    public void setId(String id){this.id = id;}
    public void setValue(int value){this.value = value;}
    public void setParent(Vertex parent){this.parent = parent;}

    @Override
    public String toString() {
        return "Vertex [id=" + id + ", value=" + value + ", parent=" + parent + "]";
    }
}

class irrigation {
   static int INFINITY = 999999999;
   public static int calculate(int xi, int yi, int xf, int yf){
       return (xi-xf)*(xi-xf)+(yi-yf)*(yi-yf);
   }

    /*PRIM MST*/

    public static void primMST(int sizeV, int[][] matrixAdj, Vertex[] listVertex){

        Vertex[] result = new Vertex[sizeV];
        Vertex currentVertex = null;
        int oldSize = 0;

        listVertex[0].setValue(0); //Atribui zero ao vertice inicial
        /*q eh a lista de vertices a serem investigados*/
        ArrayList<Vertex> q = buildMinHeap(listVertex.clone());

        while ((oldSize = q.size()) != 0){
            currentVertex = q.remove(0);		//Remove o menor valor (primeiro vertex da list)

            for (Vertex v : currentVertex.getListAdj()){
                if(q.contains(v) && matrixAdj[currentVertex.getId()][v.getId()] < v.getValue()){
                    v.setParent(currentVertex);		//Atribui o vertice retirado como o novo pai
                    v.setValue(matrixAdj[currentVertex.getId()][v.getId()]);	//Modifica o valor do vertice pelo peso da aresta correspondente
                }
            }

            q = buildMinHeap(q.toArray(new Vertex[q.size()]));

            result[sizeV - oldSize] = currentVertex;		//Guarda os vertices ja acessados
        }

        int total = 0;
        System.out.println("Result Set:");
        for(int i = 0; i < result.length; i++){

            if(result[i].getParent() != null)
                System.out.println(result[i].getId()+"-"+result[i].getParent().getId()+" (value = "+result[i].getValue()+")");
            else
                System.out.println(result[i].getId()+"-"+result[i].getParent()+" (value = "+result[i].getValue()+")");

            total += result[i].getValue();
        }

        System.out.println("\nTotal Value: "+total);

    }

    /*SUPPORT FUNCTIONS*/
    /*HEAP MIN*/

    private static ArrayList<Vertex> buildMinHeap(Vertex[] vet){

        for (int i = (vet.length/2)-1; i >= 0; i--)
            minHeapfy(vet,vet.length,i);

        ArrayList<Vertex> ret = new ArrayList<Vertex>();

        for (int i = 0; i < vet.length; i++)
            ret.add(vet[i]);

        return ret;
    }

    private static Vertex[] minHeapfy(Vertex[] vet, int n, int index){
        int min = index, left = 2 * index, right = 2 * index + 1;

        if ((left <= n - 1) && (vet[left].getValue() < vet[min].getValue()))
            min = left;

        if((right <= n-1) && (vet[right].getValue() < vet[min].getValue()))
            min = right;

        if(min != index){
            Vertex aux = vet[index];
            vet[index] = vet[min];
            vet[min] = aux;

            return minHeapfy(vet,n,min);
        }

        return vet;
    }

    private static void showBiMatrix(int[][] m){
        for (int[] rows : m) {
            for (int col : rows) {
                System.out.format("%5d", col);
            }
            System.out.println();
        }
        System.out.println();
    }

    /*
        Modelo de entrada:
            n
            mAdj[i,j]


    */
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        String[] temp;
        //3 11
        //0 2
        //5 0
        //4 3

        temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int C = Integer.parseInt(temp[1]);
        temp = br.readLine().split(" ");
        int init_i = Integer.parseInt(temp[0]);
        int init_j = Integer.parseInt(temp[1]);
        int[][] matrixAdj = new int[N][N];
        Vertex[] listVertex = new Vertex[N];
        listVertex[0] = new Vertex(init_i + "x" + init_j, INFINITY, null);
        for (int i = 1; i < N; i++) {
            temp = br.readLine().split(" ");
            int cur_i = Integer.parseInt(temp[0]);
            int cur_j = Integer.parseInt(temp[1]);
            listVertex[i] = new Vertex(cur_i + "x" + cur_j, INFINITY, null);

        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (boolean true) {
                    int value = Integer.parseInt(listVertex[i]);
                    matrixAdj[i][j] = value;
                    matrixAdj[j][i] = value;

                    if (value != 0) {
                        listVertex[i].getListAdj().add(listVertex[j]);
                        listVertex[j].getListAdj().add(listVertex[i]);
                    }

                    k++;
                } else {
                    j--;
                    k++;
                }
            }
        }
        showBiMatrix(matrixAdj);
        primMST(N, matrixAdj, listVertex);
    }
}
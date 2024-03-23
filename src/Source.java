//Piotr Kondziolka - 7
import java.util.Scanner;

class Source {

    public static Scanner scanner = new Scanner(System.in); //tworzymy obiekt scanner

    //bubblesort ( zlozonosc On2 )
    public static void bubbleSort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])
                {
                    //swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }

    public static void result(int arr[], int n) {

        //sortowanie tablicy
        bubbleSort(arr);

        //wypisanie tablicy
        for(int i = 0; i < n; i++){

            //wypisujemy po 25 elementow w wierszu
            if(i!=0 && i%25 == 0) {
                System.out.println();
            }
            System.out.print(arr[i]);

            if(i != n-1){
                System.out.print(" ");
            }
        }
        System.out.println();


        int counter = 0;
        int x = 0;
        int k = 0;
        int counter10 = 0;

        for (int i = 0;   i < n - 2 ;   i++) {
            for (int j = i + 1;   j < n - 1;   j++) {

                x = arr[i] + arr[j];
                k = j + 1;  //indeks k ustawiamy na wartosc o 1 wieksza od indeksu j ( drugiego boku trojkata )

                //Wartosci pod indeksami i,j to dwa pierwsze boki trojkata, wartosc pod indeksem k to poszukiwany trzeci
                //bok. Skoro tablica jest posortowana to inkrementujac indeks k ( przy prawdziwosci warunku (k < n && arr[k] < x) )
                //zliczamy mozliwe trojkaty pamietajac o odjeciu wartosci (j+1) bedacej poczatkowa wartoscia indeksu k. Calosc
                //daje nam oczekiwana zlozonsc On2

                while(k < n && arr[k] < x) {
                    counter10++;        //chcemy wypisac tylko 10 pierwszych trojek indeksow
                    if(counter10 < 10) {
                        System.out.print("(" + i + "," + j + "," + k + ") ");   //spacja na koncu
                    }
                    if(counter10 == 10){
                        System.out.print("(" + i + "," + j + "," + k + ")");    //bez spacji na koncu
                    }

                    k++;    //indeks k zawsze bedzie o 1 za duzy
                }

                counter += k - j - 1;
            }
        }
        if(counter != 0){
            System.out.println();
            System.out.println("Number of triangles: " + counter);
        }
        else{
            System.out.println("Triangles cannot be built");
        }
    }

    public static void main(String[] args) {

        int i = 0;
        int size = 0;
        int lb_zestawow = scanner.nextInt();

        while(i < lb_zestawow){

            size = scanner.nextInt();       //wczytanie rozmiaru tablicy T[]
            int T[] = new int[size];

            for(int j=0; j<size; j++){
                T[j] = scanner.nextInt();   //wypelnienie tablicy
            }

            System.out.println(i+1 + ": n= " + size);
            result(T, size);

            i++;
        }
    }
}

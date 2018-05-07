package uebungsblatt2;

public class Main {

    /* START OF TESTING */
    public static int[] emptyArray     = {};  // empty
    public static int[] singletonArray = {1}; // = (1)
    public static int[] generalArray   = new int[333];

    public static void setUpGeneralArray() {
        for (int i=0; i<generalArray.length; i++) {
            generalArray[i] = 3*i;
        }
    }

    public static void searchInArray(int[] array, int key) {
        int linearResult   = linearSearch(array, key);
        int binaryResult   = binarySearch(array, key);
        int interpolResult = interpolationSearch(array, key);

        if (linearResult != -1) {
            System.out.println("Linear search: " + key + " found in possition " + linearResult);
        }
        else {
            System.out.println("Linear search: " + key + " not found in array");
        }

        if (binaryResult != -1) {
            System.out.println("Binary search: " + key + " found in possition " + binaryResult);
        }
        else {
            System.out.println("Binary search: " + key + " not found in array");
        }

        if (interpolResult != -1) {
            System.out.println("Interpolation search: " + key + " found in possition " + interpolResult);
        }
        else {
            System.out.println("Interpolation search: " + key + " not found in array");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        setUpGeneralArray();

        // the keys to search
        int[] keys = {-10000, -1000, -333, -100, -2, -1, 0, 1, 2, 100, 333, 1000, 10000};

        // test all keys
        for (int i=0; i < keys.length; i++) {
            System.out.println("Searching for key " + keys[i] + " in the first array:");
            searchInArray(emptyArray, keys[i]);
            System.out.println("Searching for key " + keys[i] + " in the second array:");
            searchInArray(singletonArray, keys[i]);
            System.out.println("Searching for key " + keys[i] + " in the third array:");
            searchInArray(generalArray, keys[i]);
            System.out.println();
        }
    }
    /* END OF TESTING */


    /**
     * Implementation of linear search. Return the index of key in the array.
     * Return -1 if key is not contained in the array.
     * @param array
     * @param key
     * @return
     */
    public static int linearSearch(int[] array, int key) {
        // TODO: Implementation goes here.
        int next = 0;
        //Check Array lenght to avoid Array out of Bounds Exception
        switch (array.length) {
            //Falls LÃ¤nge = 0, enthÃ¤lt das Array keine Elemente und die Suche kann abgebrochen werden
            case 0:
                break;
            default:
                //Solange die gesuchte Zahl grÃ¶Ãer als die nÃ¤chste Zahl im Array ist wird das Array Schritt fÃ¼r Schritt durchgegangen
                //Falls die maximale ArraylÃ¤nge erreicht wurde, wird die Suche abgebrochen, da sich die Zahl nicht im Array befindet
                while(key > array[next]) {
                    if (next < array.length-1) {
                        next = next+1;
                    } else {
                        break;
                    }
                }
                // Da die Zahl nach der While Schlife nicht mehr grÃ¶Ãer als die aktuelle Zahl im Array sein kann, wird Ã¼berprÃ¼ft ob die Zahl im Array und die gesuchte Zahl Ã¼bereinstimmen.
                //Ist das der Fall wird der Index next zurÃ¼ckgegeben, ansonsten -1 da die Zahl nicht im Array vorkommt
                if (key == array[next]) {
                    return next;
                }
                break;
        }
        return -1;

    }


    /**
     * Implementation of binary search. Return the index of key in the array.
     * Return -1 if key is not contained in the array.
     * @param array
     * @param key
     * @return
     */
    public static int binarySearch(int[] array, int key) {
        // TODO: Implementation goes here.
        int oben = array.length -1;
        int unten = 0;
        int next;
        //ÃberprÃ¼fung der ArraylÃ¤nge um Exceptions zu vermeiden.
        switch (array.length) {
            //Falls LÃ¤nge = 0, enthÃ¤lt das Array keine Elemente und die Suche kann abgebrochen werden
            case 0:
                break;
            //Falls LÃ¤nge = 1, entsteht durch oben-unten = (arraylÃ¤nge - 1)-0 = (1-1)-0 eine Bedingung durch die die While-Schleife nicht aufgerufen wird.
            //Daher direkt die Ã¼berprÃ¼fung ob die gesuchte Zahl dem Element entspricht
            case 1:
                if (key == array[0]) {
                    return 0;
                }
                break;
            default:
                //Solange es mehr als ein Element gibt, wird der nÃ¤chste Index berechnet
                //DafÃ¼r wird die Anzahl der Elemente halbiert und aufgerundet um eine Integer zu erhalten.
                //ZusÃ¤tzlich muss die untere Grenze dazuaddiert werden um 'next' oberhalb der Untergrenze zu haben.
                //Dann wird Ã¼berprÃ¼ft ob die gesuchte Zahl dem Wert im Array[next] entspricht oder grÃ¶Ãer (kleiner) ist.
                //Falls die Zahl grÃ¶Ãer(kleiner) ist, wird die Untere (Obere) Grenze auf den Wert von next gesetzt.
                //Entspricht die Zahl im Array[next] der gesuchten Zahl, wird die Zahl zurÃ¼ckgegeben.
                while (oben-unten >1) {
                    next = (int) Math.ceil((oben-unten)/2)+unten;
                    if (key == array[next]) {
                        return next;
                    }else if(key < array[next]) {
                        oben = next ;
                    }else if(key > array[next]) {
                        unten = next ;
                    }
                }
        }

        return -1;
    }


    /**
     * Implementation of interpolation search. Return the index of key in the array.
     * Return -1 if key is not contained in the array.
     * @param array
     * @param key
     * @return
     */
    public static int interpolationSearch(int[] array, int key) {
        // TODO: Implementation goes here.
        int unten = 0;
        int oben = array.length-1;
        int next;
        //ÃberprÃ¼fung der ArraylÃ¤nge um Exceptions zu vermeiden.
        switch (array.length) {
            //Falls LÃ¤nge = 0, enthÃ¤lt das Array keine Elemente und die Suche kann abgebrochen werden
            case 0:
                break;
            //Falls LÃ¤nge = 1, entsteht durch array[oben] = array[0] eine Division durch Null (array[oben] = array[unten] => 1-1 = 0.
            //Daher direkt die Ã¼berprÃ¼fung ob die gesuchte Zahl dem Element entspricht
            case 1:
                if (key == array[0]) {
                    return 0;
                }
                break;
            default:
                //Solange sich der Key im Array berechnet sich der Index mit einer abgewandelten Form der BinÃ¤rsuche (Siehe Skript)
                //AnschlieÃend wird ebenfalls Ã¼berprÃ¼ft ob die gesuchte Zahl dem Wert im Array[next] entspricht oder grÃ¶Ãer (kleiner) ist.
                //Falls die Zahl grÃ¶Ãer(kleiner) ist, wird die Untere (Obere) Grenze auf den Wert von next+1 (next-1) gesetzt.
                //Entspricht die Zahl im Array[next] der gesuchten Zahl, wird die Zahl zurÃ¼ckgegeben.
                while(key >= array[unten] && key <= array[oben]) {
                    next = unten + (int) Math.floor((key-array[unten])/(array[oben]-array[unten]) *(oben-unten));
                    if(key > array[next]) {
                        unten = next +1;
                    }else if (key < array[next]) {
                        oben = next -1;
                    }else {
                        return next;
                    }
                }
        }
        return -1;
    }

}
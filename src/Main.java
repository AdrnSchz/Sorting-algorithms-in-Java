import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int opt, opt2;
        String file = null;
        List<Shoe> list = new ArrayList<>();
        int numShoes = 0;
        long t1 = 0, t2 = 0;

        System.out.println("Welcome to Zaballos Zapatery!\n");

        System.out.println("Chose an option:");
        System.out.println("\t1. List by name");
        System.out.println("\t2. List by quality");

        do {
            System.out.print("> ");

            opt = getInt();

            if (opt < 1 || opt > 2) {
                System.out.println("\nPlease, enter a valid option");
            }
        } while (opt < 1 || opt > 2);

        switch (opt) {
            case 1 -> {
                System.out.println("\nDataset:");
                System.out.println("\t1. Ascending");
                System.out.println("\t2. Descending");
                System.out.println("\t3. Random");
                System.out.println("\t4. Mini");
                do {
                    System.out.print("> ");

                    opt2 = getInt();

                    if (opt2 < 1 || opt2 > 4) {
                        System.out.println("\nPlease, enter a valid option");
                    }

                } while (opt2 < 1 || opt2 > 4);
                switch (opt2) {
                    case 1 -> file = "Datasets/ascending.txt";
                    case 2 -> file = "Datasets/descending.txt";
                    case 3 -> file = "Datasets/random.txt";
                    case 4 -> file = "Datasets/mini.txt";
                }
                try {
                    File fileObj = new File(file);
                    Scanner scF = new Scanner(fileObj);

                    if (file.equals("Datasets/mini.txt")) {
                        numShoes = scF.nextInt();
                    }
                    else {
                        System.out.println("\nNumber of shoes:");
                        System.out.println("\t1. 10000");
                        System.out.println("\t2. 50000");
                        System.out.println("\t3. 100000");
                        System.out.println("\t4. 250000");
                        System.out.println("\t5. 350000");
                        System.out.println("\t6. 524288");
                        do {
                            System.out.print("> ");

                            opt2 = getInt();

                            if (opt2 < 1 || opt2 > 6) {
                                System.out.println("\nPlease, enter a valid option");
                            }

                        } while (opt2 < 1 || opt2 > 6);
                        switch (opt2) {
                            case 1 -> numShoes = 10000;
                            case 2 -> numShoes = 50000;
                            case 3 -> numShoes = 100000;
                            case 4 -> numShoes = 250000;
                            case 5 -> numShoes = 350000;
                            case 6 -> numShoes = 524288;
                        }
                    }
                    scF.nextLine();
                    for (int i = 0; i < numShoes; i++) {
                        Shoe shoe = new Shoe();
                        String[] line = scF.nextLine().split(";");
                        line[1] = line[1].replace(",", ".");
                        line[5] = line[5].replace(",", ".");
                        shoe.setName(line[0]);
                        shoe.setPrice(Float.parseFloat(line[1]));
                        shoe.setMinSize(Integer.parseInt(line[2]));
                        shoe.setMaxSize(Integer.parseInt(line[3]));
                        shoe.setWight(Integer.parseInt(line[4]));
                        shoe.setScore(Float.parseFloat(line[5]));
                        shoe.setQuality();
                        list.add(shoe);
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("ERROR: File not found");
                }

                System.out.println("\nList by name: ");
                System.out.println("\t1. Insertion sort");
                System.out.println("\t2. Selection sort");
                do {
                    System.out.print("> ");

                    opt2 = getInt();

                    if (opt2 < 1 || opt2 > 2) {
                        System.out.println("\nPlease, enter a valid option");
                    }
                } while (opt2 < 1 || opt2 > 2);
                switch (opt2) {
                    case 1 -> {
                        t1 = System.currentTimeMillis();
                        insertionSort(list);
                        t2 = System.currentTimeMillis();
                        System.out.println("Insertion sort:");
                    }
                    case 2 -> {
                        t1 = System.currentTimeMillis();
                        selectionSort(list);
                        t2 = System.currentTimeMillis();
                        System.out.println("Selection sort:");
                    }
                }
                printList(list);
                System.out.println("\nTime: " + ((t2 - t1) / 1000.0f) + " seconds");
            }
            case 2 -> {
                try {
                    File fileObj = new File("Datasets/random.txt");
                    Scanner scF = new Scanner(fileObj);

                    System.out.println("\nNumber of shoes:");
                    System.out.println("\t1. 10000");
                    System.out.println("\t2. 50000");
                    System.out.println("\t3. 100000");
                    System.out.println("\t4. 250000");
                    System.out.println("\t5. 350000");
                    System.out.println("\t6. 524288");
                    do {
                        System.out.print("> ");

                        opt2 = getInt();

                        if (opt2 < 1 || opt2 > 6) {
                            System.out.println("\nPlease, enter a valid option");
                        }

                    } while (opt2 < 1 || opt2 > 6);
                    switch (opt2) {
                        case 1 -> numShoes = 10000;
                        case 2 -> numShoes = 50000;
                        case 3 -> numShoes = 100000;
                        case 4 -> numShoes = 250000;
                        case 5 -> numShoes = 350000;
                        case 6 -> numShoes = 524288;
                    }

                    scF.nextLine();
                    for (int i = 0; i < numShoes; i++) {
                        Shoe shoe = new Shoe();
                        String[] line = scF.nextLine().split(";");
                        line[1] = line[1].replace(",", ".");
                        line[5] = line[5].replace(",", ".");
                        shoe.setName(line[0]);
                        shoe.setPrice(Float.parseFloat(line[1]));
                        shoe.setMinSize(Integer.parseInt(line[2]));
                        shoe.setMaxSize(Integer.parseInt(line[3]));
                        shoe.setWight(Integer.parseInt(line[4]));
                        shoe.setScore(Float.parseFloat(line[5]));
                        shoe.setQuality();
                        list.add(shoe);
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("ERROR: File not found");
                }

                System.out.println("\nList by quality: ");
                System.out.println("\t1. Quicksort");
                System.out.println("\t2. Mergesort");
                do {
                    System.out.print("> ");

                    opt2 = getInt();

                    if (opt2 < 1 || opt2 > 2) {
                        System.out.println("\nPlease, enter a valid option");
                    }
                } while (opt2 < 1 || opt2 > 2);
                switch (opt2) {
                    case 1 -> {
                        t1 = System.currentTimeMillis();
                        quickSort(list, 0, list.size() - 1);
                        t2 = System.currentTimeMillis();
                    }
                    case 2 -> {
                        t1 = System.currentTimeMillis();
                        mergesort(list, 0, list.size() - 1);
                        t2 = System.currentTimeMillis();
                    }
                }
                printQuality(list);
                System.out.println("\nTime: " + ((t2 - t1) / 1000.0f) + " seconds");
            }
            default -> {
            }
        }
    }

    private static void insertionSort(List<Shoe> shoes) {
        int n = shoes.size();
        for (int i = 1; i < n; ++i) {
            Shoe shoe = shoes.get(i);
            int j = i - 1;

            while (j >= 0 && strcmp(shoes.get(j).getName(), shoe.getName()) >= 0) {
                shoes.set(j + 1, shoes.get(j));
                j = j - 1;
            }
            shoes.set(j + 1, shoe);
        }

    }

    private static void selectionSort(List<Shoe> shoes) {
        int n = shoes.size();

        for (int i = 0; i < n-1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (strcmp(shoes.get(j).getName(), shoes.get(min_idx).getName()) <= 0) {
                    min_idx = j;
                }
            }
            Shoe shoe = shoes.get(min_idx);
            shoes.set(min_idx, shoes.get(i));
            shoes.set(i, shoe);

        }
    }

    private static int getInt() {
        int num;
        try {
            num = sc.nextInt();
        } catch (InputMismatchException e) {
            num = -1;
            sc.nextLine();
        }

        return num;
    }

    static void swap(List<Shoe> shoes, int i, int j) {
        Shoe temp = shoes.get(i);
        shoes.set(i, shoes.get(j));
        shoes.set(j, temp);
    }
    static int partition(List<Shoe> shoes, int low, int high) {
        Shoe pivot = shoes.get(high);
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            if (shoes.get(j).getQuality() > pivot.getQuality()) {
                i++;
                swap(shoes, i, j);
            }
        }
        swap(shoes, i + 1, high);
        return (i + 1);
    }
    private static void quickSort(List<Shoe> shoes, int low, int high) {
        if (low < high) {
            int p = partition(shoes, low, high);

            quickSort(shoes, low, p - 1);
            quickSort(shoes, p + 1, high);
        }
    }

    private static void merge(List<Shoe> shoes, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        List<Shoe> left = new ArrayList<>();
        List<Shoe> right = new ArrayList<>();

        for (int i = 0; i < n1; ++i) {
            left.add(shoes.get(l + i));
        }
        for (int j = 0; j < n2; ++j) {
            right.add(shoes.get(m + 1 + j));
        }

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (left.get(i).getQuality() >= right.get(j).getQuality()) {
                shoes.set(k, left.get(i));
                i++;
            } else {
                shoes.set(k, right.get(j));
                j++;
            }
            k++;
        }

        while (i < n1) {
            shoes.set(k, left.get(i));
            i++;
            k++;
        }

        while (j < n2) {
            shoes.set(k, right.get(j));
            j++;
            k++;
        }
    }
    private static void mergesort(List<Shoe> shoes, int l, int r) {
        if (l < r) {

            int m = l + (r - l) / 2;

            mergesort(shoes, l, m);
            mergesort(shoes, m + 1, r);

            merge(shoes, l, m, r);
        }
    }

    private static int strcmp(String str1, String str2) {

        int l1 = str1.length();
        int l2 = str2.length();
        int min = Math.min(l1, l2);

        for (int i = 0; i < min; i++) {
            int str1_ch = str1.charAt(i);
            int str2_ch = str2.charAt(i);

            if (str1_ch != str2_ch) {
                return str1_ch - str2_ch;
            }
        }

        if (l1 != l2) {
            return l1 - l2;
        }

        else {
            return 0;
        }
    }

    private static void printList(List<Shoe> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i).getName());
        }
    }

    private static void printQuality(List<Shoe> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i).getName() + " - " + list.get(i).getQuality());
        }
    }
}

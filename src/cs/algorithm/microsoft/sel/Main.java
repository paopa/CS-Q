package cs.algorithm.microsoft.sel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Application.start();
    }
}

class Application {
    public static void start() {
        Scanner scanner = new Scanner(System.in);
        String selCount = scanner.nextLine();
        int count = Integer.parseInt(selCount);
        if (count > 100 || count < 1) {
            throw new IllegalArgumentException();
        }
        String line;
        List<String> output = new ArrayList<>();
        while (count > 0) {
            line = scanner.nextLine();
            if (line.equals(" ") || line.isEmpty()) {
                continue;
            }
            String[] seg = line.split(" ");
            int id = Integer.valueOf(seg[1] + seg[0], 16);
            int year = Integer.valueOf(seg[3] + seg[2], 16);
            int month = Integer.valueOf(seg[4], 16);
            int day = Integer.valueOf(seg[5], 16);
            int hour = Integer.valueOf(seg[6], 16);
            int min = Integer.valueOf(seg[7], 16);
            String generator = (seg[8] + seg[9]).equals("d200") ? "BIOS" : "BMC";
            String status = (seg[10].equals("01")) ? "Success" : "Fail";
            output.add(String.format("Record %s: %s/%02d/%02d %02d:%02d %s Event %s", id, year, month, day, hour, min, generator, status));
            count--;
        }
        output.forEach(System.out::println);
    }
}

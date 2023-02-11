package javadeveloper.module7.httpstatus;

import java.util.Scanner;

public class HttpImageStatusCLI {
    public void askStatus() {
        Scanner input = new Scanner(System.in);
        int code = 0;
        boolean continueAsking = true;

        System.out.print("Enter HTTP status code(100-599): ");

        while (continueAsking) {
            boolean hasInputInt = input.hasNextInt();
            boolean validInterval = false;

            if (hasInputInt) {
                code = input.nextInt();
                if (code >= 100 && code < 600) validInterval = true;
            }

            if (hasInputInt && validInterval) {
                try {
                    HttpStatusImageDownloader.downloadStatusImage(code);
                } catch (ImageNotFoundException e) {
                    System.out.println("There is not image for HTTP status " + code);
                }
                continueAsking = false;
            }
            else {
                System.out.print("Please enter valid number(100-599): ");
                if (!hasInputInt) input.next();
            }
        }
    }
}
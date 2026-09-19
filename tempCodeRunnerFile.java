public class SeatDuplicationChecker {
    public static void checkDuplicateSeats(int[] seatNumbers) {
        boolean duplicateFound = false;
        
        for (int i = 0; i < seatNumbers.length; i++) {
            boolean isFirstOccurrence = true;
            for (int k = 0; k < i; k++) {
                if (seatNumbers[i] == seatNumbers[k]) {
                    isFirstOccurrence = false;
                    break;
                }
            }
            if (!isFirstOccurrence) {
                continue;
            }

            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    duplicateFound = true;
                    break;
                }
            }
        }

        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }
}
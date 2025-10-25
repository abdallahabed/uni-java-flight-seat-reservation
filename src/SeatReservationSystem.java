import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeatReservationSystem {

    private static final int NUM_SEATS = 100;
    private static JButton[] seatButtons = new JButton[NUM_SEATS];
    private static boolean[] seats = new boolean[NUM_SEATS];

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SeatReservationSystem::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Seat Reservation System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLayout(new GridLayout(10, 10, 5, 5)); // 10x10 grid for 100 seats

        // Initialize buttons
        for (int i = 0; i < NUM_SEATS; i++) {
            seatButtons[i] = new JButton("Available");
            seatButtons[i].setBackground(Color.GREEN);
            int seatIndex = i; // Necessary for the inner class to access
            seatButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    toggleSeat(seatIndex);
                }
            });
            frame.add(seatButtons[i]);
        }

        frame.setVisible(true);
    }

    private static void toggleSeat(int seatIndex) {
        if (seats[seatIndex]) {
            // Seat is reserved, so cancel the reservation
            seats[seatIndex] = false;
            seatButtons[seatIndex].setText("Available");
            seatButtons[seatIndex].setBackground(Color.GREEN);
        } else {
            // Seat is available, so reserve it
            seats[seatIndex] = true;
            seatButtons[seatIndex].setText("Reserved");
            seatButtons[seatIndex].setBackground(Color.RED);
        }
    }
}

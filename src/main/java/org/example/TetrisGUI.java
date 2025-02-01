package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class TetrisGUI extends JPanel {


    private static final int BOARD_WIDTH = 10;
    private static final int BOARD_HEIGHT = 20;
    private int[][] board = new int[BOARD_HEIGHT][BOARD_WIDTH];
    private int[][][] shapes = {
            {{1, 1, 1, 1}},
            {{1, 1}, {1, 1}},
            {{1, 1, 0}, {0, 1, 1}},
            {{0, 1, 1}, {1, 1, 0}},
            {{1, 1, 1}, {0, 1, 0}},
            {{1, 1, 0}, {1, 0, 0}},
            {{0, 1, 1}, {0, 0, 1}}
    };
//    private int[][] currentShape;
//    private int currentX, currentY;
//    private boolean gameOver = false;
//
//
//    private final int BLOCK_SIZE = 30;

//    public TetrisGUI() {
//        setPreferredSize(new Dimension(BOARD_WIDTH * BLOCK_SIZE, BOARD_HEIGHT * BLOCK_SIZE));
//        spawnPiece();
//
//        addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyPressed(KeyEvent e) {
//                if (gameOver) return;
//
//                int keyCode = e.getKeyCode();
//                if (keyCode == KeyEvent.VK_LEFT) {
//                    if (canMove(-1, 0)) currentX--;
//                } else if (keyCode == KeyEvent.VK_RIGHT) {
//                    if (canMove(1, 0)) currentX++;
//                } else if (keyCode == KeyEvent.VK_DOWN) {
//                    if (canMove(0, 1)) currentY++;
//                } else if (keyCode == KeyEvent.VK_UP) {
//                    rotatePiece();
//                }
//
//                repaint();
//            }
//        });
//
//        setFocusable(true);
//    }
//
//    public void spawnPiece() {
//        Random rand = new Random();
//        int currentPiece = rand.nextInt(7);
//        currentShape = shapes[currentPiece]; // currentShape-ni tasodifiy blok bilan to'ldirish
//        currentX = BOARD_WIDTH / 2 - 1; // O'rtada boshlash
//        currentY = 0; // Yuqoridan boshlash
//
//        // Agar blokni joylashtirish mumkin bo'lmasa, o'yin tugaydi
//        if (!canMove(0, 0)) {
//            gameOver = true;
//        }
//    }
//
//    public void placePiece() {
//        for (int i = 0; i < currentShape.length; i++) {
//            for (int j = 0; j < currentShape[i].length; j++) {
//                if (currentShape[i][j] != 0) {  // Agar blokni joylashtirish kerak bo'lsa
//                    int x = currentX + j; // Blokning x koordinatasi
//                    int y = currentY + i; // Blokning y koordinatasi
//                    if (y >= 0 && y < BOARD_HEIGHT && x >= 0 && x < BOARD_WIDTH) {
//                        board[y][x] = 1; // Blokni o'yin maydoniga joylashtirish
//                    }
//                }
//            }
//        }
//    }
//
//    public void rotatePiece() {
//        int[][] rotated = rotateMatrix(currentShape);
//        if (canMove(0, 0, rotated)) {
//            currentShape = rotated;  // Agar aylantirish mumkin bo'lsa, yangi shaklni o'rnatish
//        }
//    }
//
//    private int[][] rotateMatrix(int[][] shape) {
//        int rows = shape.length;
//        int cols = shape[0].length;
//        int[][] rotated = new int[cols][rows];
//
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                rotated[j][rows - i - 1] = shape[i][j];
//            }
//        }
//
//        return rotated;
//    }
//
//    public boolean canMove(int dx, int dy) {
//        return canMove(dx, dy, currentShape);
//    }
//
//    public boolean canMove(int dx, int dy, int[][] shape) {
//        for (int i = 0; i < shape.length; i++) {
//            for (int j = 0; j < shape[i].length; j++) {
//                if (shape[i][j] != 0) {
//                    int x = currentX + j + dx;
//                    int y = currentY + i + dy;
//                    if (x < 0 || x >= BOARD_WIDTH || y >= BOARD_HEIGHT || (y >= 0 && board[y][x] == 1)) {
//                        return false; // Agar blok o'zgarishidan keyin to'qnashuv yuz bersa
//                    }
//                }
//            }
//        }
//        return true;
//    }
//
//    public void clearLines() {
//        for (int i = BOARD_HEIGHT - 1; i >= 0; i--) {
//            boolean fullLine = true;
//            for (int j = 0; j < BOARD_WIDTH; j++) {
//                if (board[i][j] == 0) {
//                    fullLine = false;
//                    break;
//                }
//            }
//
//            if (fullLine) {
//                // To'liq qatorni tozalash va yuqoriga siljitish
//                for (int k = i; k > 0; k--) {
//                    for (int j = 0; j < BOARD_WIDTH; j++) {
//                        board[k][j] = board[k - 1][j];
//                    }
//                }
//
//                // Yuqori qatorni tozalash
//                for (int j = 0; j < BOARD_WIDTH; j++) {
//                    board[0][j] = 0;
//                }
//            }
//        }
//    }
//
//    public void update() {
//        if (gameOver) {
//            System.out.println("Game Over!");
//            return;
//        }
//
//        if (canMove(0, 1)) {
//            currentY++;
//        } else {
//            placePiece();  // Blokni joylashtirish
//            clearLines();  // To'liq qatorlarni tozalash
//            spawnPiece();  // Yangi blokni yaratish
//        }
//    }
//
//    public void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        update();  // O'yinni yangilash
//
//        // O'yin maydonini chiqarish
//        for (int i = 0; i < BOARD_HEIGHT; i++) {
//            for (int j = 0; j < BOARD_WIDTH; j++) {
//                if (board[i][j] == 1) {
//                    g.setColor(Color.RED);
//                    g.fillRect(j * BLOCK_SIZE, i * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
//                } else {
//                    g.setColor(Color.WHITE);
//                    g.fillRect(j * BLOCK_SIZE, i * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
//                    g.setColor(Color.GRAY);
//                    g.drawRect(j * BLOCK_SIZE, i * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
//                }
//            }
//        }
//
//        // Blokning o'zi
//        g.setColor(Color.BLUE);
//        for (int i = 0; i < currentShape.length; i++) {
//            for (int j = 0; j < currentShape[i].length; j++) {
//                if (currentShape[i][j] != 0) {
//                    g.fillRect((currentX + j) * BLOCK_SIZE, (currentY + i) * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        JFrame frame = new JFrame("Tetris");
//        TetrisGUI gamePanel = new TetrisGUI();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.add(gamePanel);
//        frame.pack();
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
//    }
}

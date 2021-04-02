package edu.sabana.poob.shapes;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RectangleTest {

    private static Rectangle c1;
    private static Rectangle c2;
    private static Rectangle c3;
    private static Rectangle c4;
    private static Rectangle c5;
    private static Square c6;
    private static Square c7;
    private static Square c8;
    private static Square c9;
    private static Rectangle c10;



    @BeforeAll
    public static void setUp() {
        c1 = new Rectangle(20,40);
        c2 = new Rectangle(30,45.67);
        c3 = new Rectangle("red");
        c4 = new Rectangle("red",40,56.7);
        c5 = new Rectangle();
        c6 = new Square(20);
        c7 = new Square("red");
        c8 = new Square("red",40.4);
        c9 = new Square();
        c10= new Rectangle(-20,40);
    }

    @Test
    public void shouldCalculateArea() {
        assertEquals(800, (int) c1.getArea());
        assertEquals(1370, (int) c2.getArea());
        assertEquals(1, (int) c3.getArea());
        assertEquals(2268, (int) c4.getArea());
        assertEquals(1, (int) c5.getArea());
        assertEquals(400, (int) c6.getArea());
        assertEquals(1, (int) c7.getArea());
        assertEquals(1632, (int) c8.getArea());
        assertEquals(1, (int) c9.getArea());
        assertEquals(800, (int) c10.getArea());

    }

    @Test
    public void shouldCalculatePerimeter() {

        assertEquals(120, (int) c1.getPerimeter());
        assertEquals(151, (int) c2.getPerimeter());
        assertEquals(4, (int) c3.getPerimeter());
        assertEquals(193, (int) c4.getPerimeter());
        assertEquals(4, (int) c5.getPerimeter());
        assertEquals(80, (int) c6.getPerimeter());
        assertEquals(4, (int) c7.getPerimeter());
        assertEquals(161, (int) c8.getPerimeter());
        assertEquals(4, (int) c9 .getPerimeter());
        assertEquals(120, (int) c10.getPerimeter());


    }

    @Test
    public void shouldCalculateDiagonal() {

        assertEquals(44, (int) c1.getDiagonal());
        assertEquals(54, (int) c2.getDiagonal());
        assertEquals(1, (int) c3.getDiagonal());
        assertEquals(69, (int) c4.getDiagonal());
        assertEquals(1, (int) c5.getDiagonal());
        assertEquals(28, (int) c6.getDiagonal());
        assertEquals(1, (int) c7.getDiagonal());
        assertEquals(57, (int) c8.getDiagonal());
        assertEquals(1, (int) c9.getDiagonal());
        assertEquals(44, (int) c10.getDiagonal());


    }

    @Test
     public void shouldPrintCircle() {

        assertEquals("This is a Rectangle with color NONE and diagonal 44,72", c1.toString());
        assertEquals("This is a Rectangle with color NONE and diagonal 54,64", c2.toString());
        assertEquals("This is a Rectangle with color red and diagonal 1,41", c3.toString());
        assertEquals("This is a Rectangle with color red and diagonal 69,39", c4.toString());
        assertEquals("This is a Rectangle with color NONE and diagonal 1,41", c5.toString());
        assertEquals("This is a Square with color NONE and diagonal 28,28", c6.toString());
        assertEquals("This is a Square with color red and diagonal 1,41", c7.toString());
        assertEquals("This is a Square with color red and diagonal 57,13", c8.toString());
        assertEquals("This is a Square with color NONE and diagonal 1,41", c9.toString());




    }

}

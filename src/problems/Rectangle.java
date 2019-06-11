
class Point
{
    double x, y;

    public Point(double a, double b)
    {
        x = a;
        y = b;
    }
}

public class Rectangle
{
    Point leftTop;
    Point rightBottom;

    public Rectangle(Point p1, Point p2)
    {
        leftTop = p1;
        rightBottom = p2;
    }

    public boolean doesRectanglesOverLap(Rectangle r1, Rectangle r2)
    {
        if (r1.leftTop.x >= r2.rightBottom.x || r2.leftTop.x >= r1.rightBottom.x)
            return false;
        if (r1.leftTop.y <= r2.rightBottom.y || r2.leftTop.y <= r1.rightBottom.y)
            return false;
        return true;
    }
}

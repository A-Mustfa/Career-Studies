package SOLID.L;

public class Square extends Rectangle{
    public Square(){}

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = this.height = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.width = this.height = height;
    }
    // solution
    public void setSquareTall(int tall){
        super.setHeight(tall);
        super.setWidth(tall);
    }
}

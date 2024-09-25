import java.awt.Graphics;
import java.awt.Color;

// 
// Decompiled by Procyon v0.5.36
// 

public class Sampler
{
    private double myX;
    private double myY;
    private double myDiameter;
    private Color myColor;
    private double myRadius;
    
    public Sampler() {
        this.myX = 200.0;
        this.myY = 200.0;
        this.myDiameter = 25.0;
        this.myColor = Color.RED;
        this.myRadius = this.myDiameter / 2.0;
    }
    
    public Sampler(final double x, final double y, final double d, final Color c) {
        this.myX = x;
        this.myY = y;
        this.myDiameter = d;
        this.myColor = c;
        this.myRadius = d / 2.0;
    }
    
    public double getX() {
        return this.myX;
    }
    
    public double getY() {
        return this.myY;
    }
    
    public double getDiameter() {
        return this.myDiameter;
    }
    
    public Color getColor() {
        return this.myColor;
    }
    
    public double getRadius() {
        return this.myRadius;
    }
    
    public void setX(final double x) {
        this.myX = x;
    }
    
    public void setY(final double y) {
        this.myY = y;
    }
    
    public void setColor(final Color c) {
        this.myColor = c;
    }
    
    public void setDiameter(final double d) {
        this.myDiameter = d;
        this.myRadius = d / 2.0;
    }
    
    public void setRadius(final double r) {
        this.myRadius = r;
        this.myDiameter = 2.0 * r;
    }
    
    public void jump(final int rightEdge, final int bottomEdge) {
        this.myX = Math.random() * (rightEdge - this.myDiameter) + this.myRadius;
        this.myY = Math.random() * (bottomEdge - this.myDiameter) + this.myRadius;
    }
    
    public void draw(final Graphics myBuffer) {
        myBuffer.setColor(this.myColor);
        myBuffer.fillOval((int)(this.myX - this.myRadius), (int)(this.myY - this.myRadius), (int)this.myDiameter, (int)this.myDiameter);
    }
}
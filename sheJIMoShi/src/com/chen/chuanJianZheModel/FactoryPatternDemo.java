package com.chen.chuanJianZheModel;

/**
 * 工厂模式
 * 陈宇超
 * 10:30
 */
public class FactoryPatternDemo {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape = shapeFactory.getShape("1");
        shape.draw();
    }
}

/**
 * 图形
 * 创建一个接口
 */
interface Shape {
    void draw();
}


/**
 * 长方形
 */
class Rectangle implements Shape{

    @Override
    public void draw() {
        System.out.println("这是一个长方形");
    }
}

/**
 * 方形
 */
class Square implements Shape{
    @Override
    public void draw() {
        System.out.println("这是一个方形");
    }
}

/**
 * 圆形
 */
class Circle implements Shape{

    @Override
    public void draw() {
        System.out.println("这是一个圆形");
    }
}

class ShapeFactory {
    public Shape getShape(String shapeType){
        if ("1".equals(shapeType)){
            return new Rectangle();
        }else if ("2".equals(shapeType)){
            return new Square();
        }else if ("3".equals(shapeType)){
            return new Circle();
        }


        return null;
    }
}

package edu.up.isgc.cg.raytracer.objects;

import edu.up.isgc.cg.raytracer.Vector3D;

import java.awt.*;

public abstract class Object3D implements IIntersectable{
    private Color color;
    private Vector3D position;
    private double shininess;
    private double reflectivity;

    private double refraction;

    /**
     *  * Class: PointLight
     *  * Authors: Jafet
     *  * Co-author: Diego Sebastián Montoya Rodríguez
     *  * Date: 2024-06-06
     * @param position
     * @param color
     * @param shininess
     * @param reflectivity
     * @param refraction
     */
    public Object3D(Vector3D position, Color color, double shininess,  double reflectivity,double refraction ) {
        setPosition(position);
        setColor(color);
        setShininess(shininess);
        setReflectivity(reflectivity);
        setRefraction(refraction);
    }

    public double getRefraction() {
        return refraction;
    }

    public void setRefraction(double refraction) {
        this.refraction = refraction;
    }


    public double getReflectivity() {
        return reflectivity;
    }

    public void setReflectivity(double reflectivity) {
        this.reflectivity = reflectivity;
    }
    public double getShininess() {
        return shininess;
    }

    public void setShininess(double shininess) {
        this.shininess = shininess;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Vector3D getPosition() {
        return position;
    }

    public void setPosition(Vector3D position) {
        this.position = position;
    }
}

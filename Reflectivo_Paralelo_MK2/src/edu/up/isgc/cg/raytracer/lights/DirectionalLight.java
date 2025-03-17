package edu.up.isgc.cg.raytracer.lights;

import edu.up.isgc.cg.raytracer.Intersection;
import edu.up.isgc.cg.raytracer.Ray;
import edu.up.isgc.cg.raytracer.Vector3D;

import java.awt.*;

/**
 *  * Author: Diego Sebastian Montoya Rodriguez
 *  * @Coauthor: Jafet
 *  * This class represents a directional light in a ray tracing environment. A directional light
 *  * emits light in a specific direction from an infinite distance, with no attenuation by distance.
 *  * The intensity of the light can vary, and a color can be defined for the light
 * */
public class DirectionalLight extends Light {
    private Vector3D direction;

    public DirectionalLight(Vector3D direction, Color color, double intensity) {
        super(Vector3D.ZERO(), color, intensity);
        setDirection(direction);
    }

    public Vector3D getDirection() {
        return direction;
    }

    public void setDirection(Vector3D direction) {
        this.direction = Vector3D.normalize(direction);
    }

    @Override
    public double getNDotL(Intersection intersection) {
        return Math.max(Vector3D.dotProduct(intersection.getNormal(), Vector3D.scalarMultiplication(getDirection(), -1.0)), 0.0);
    }

}

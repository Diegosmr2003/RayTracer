package edu.up.isgc.cg.raytracer.lights;

import edu.up.isgc.cg.raytracer.Intersection;
import edu.up.isgc.cg.raytracer.Vector3D;

import java.awt.*;
/*
 * Class: PointLight
 * Authors: Jafet
 * Co-author: Diego Sebastián Montoya Rodríguez
 * Date: 2024-06-06
 *
 * Description:
 * This class represents a point light in a ray tracing environment. A point light emits light from a specific
 * position in all directions, similar to a light bulb. The intensity of the light can vary, and a color can be defined
 * for the light.
 */


public class PointLight extends Light {
    public PointLight(Vector3D position, Color color, double intensity) {
        super(position, color, intensity);
    }

    @Override
    public double getNDotL(Intersection intersection) {
        return Math.max(
                Vector3D.dotProduct(intersection.getNormal(),
                        Vector3D.normalize(Vector3D.substract(getPosition(), intersection.getPosition()))),
                0.0);
    }
}

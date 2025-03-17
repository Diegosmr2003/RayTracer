package edu.up.isgc.cg.raytracer.lights;

import edu.up.isgc.cg.raytracer.Intersection;
import edu.up.isgc.cg.raytracer.Ray;
import edu.up.isgc.cg.raytracer.Vector3D;
import edu.up.isgc.cg.raytracer.objects.Object3D;

import java.awt.*;
/*
 * Class: DirectionalLight
 * Authors: Jafet
 * Co-author: Diego Sebastián Montoya Rodríguez
 * Date: 2024-06-06
 *
 * Description:
 * This class represents a directional light in a ray tracing environment. A directional light
 * emits light in a specific direction from an infinite distance, with no attenuation by distance.
 * The intensity of the light can vary, and a color can be defined for the light.
 */
public abstract class Light extends Object3D {
    private double intensity;

    public Light(Vector3D position, Color color, double intensity) {
        super(position, color, 0,0,0);
        setIntensity(intensity);
    }

    public double getIntensity() {
        return intensity;
    }

    public void setIntensity(double intensity) {
        this.intensity = intensity;
    }

    public abstract double getNDotL(Intersection intersection);

    @Override
    public Intersection getIntersection(Ray ray) {
        return new Intersection(Vector3D.ZERO(), -1, Vector3D.ZERO(), null);
    }
}

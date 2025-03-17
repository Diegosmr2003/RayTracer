package edu.up.isgc.cg.raytracer;

import edu.up.isgc.cg.raytracer.lights.DirectionalLight;
import edu.up.isgc.cg.raytracer.lights.Light;
import edu.up.isgc.cg.raytracer.lights.PointLight;
import edu.up.isgc.cg.raytracer.objects.*;
import edu.up.isgc.cg.raytracer.tools.OBJReader;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/**
 * Class: Raytracer
 * Author: Diego Sebastian Montoya Rodriguez
 * @Coauthor: Jafet
 * Date: 2024-06-06
 *
 * The Raytracer class handles the main functionality of the ray tracing application.
 * It initializes scenes, adds objects and lights to the scenes, and renders the scenes
 * using a multithreaded approach to enhance performance.
 */
public class Raytracer {
    static BufferedImage image;
    /**
     * Main method that initializes and renders various scenes.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        System.out.println(new Date());

//ESCENA 3-----------------------------------------------------------------------
        Scene scene03 = new Scene();
        scene03.setCamera(new Camera(new Vector3D(0, 0, -4), 60, 60, 500, 500, 0.6, 50.0));

        scene03.addLight(new PointLight(new Vector3D(0.0, 1.5, -1.5),Color.WHITE, 20.0));
        scene03.addLight(new PointLight(new Vector3D(2.0, 1.0, 0.0), Color.WHITE, 15.0));

        scene03.addObject(OBJReader.getModel3D("Plano.obj", new Vector3D(0f, -1.0, 0.0), Color.WHITE, 90, 0,0));
        scene03.addObject(OBJReader.getModel3D("PlanoVertical2.obj", new Vector3D(0f, 0.0, 9), Color.black, 90, 0,0));
        scene03.addObject(OBJReader.getModel3D("SILLA.obj", new Vector3D(0.0, -1.0, -0.5), Color.MAGENTA, 90, 0.8,10));

        scene03.addObject(OBJReader.getModel3D("TABLA_MESA.obj", new Vector3D(0.0, -1.0, -1), Color.DARK_GRAY, 90, 0.8,0));
        scene03.addObject(OBJReader.getModel3D("PATAS_MESA.obj", new Vector3D(0.0, -1.0, -1), Color.DARK_GRAY, 90, 0,0));


        scene03.addObject(OBJReader.getModel3D("PLATO.obj", new Vector3D(0.0, -1.0, -1), Color.red, 90, 0.8,10));
        scene03.addObject(new Sphere(new Vector3D(-1, 0.3, -.5), 0.2, Color.RED,90, 0.7,1.5));
        scene03.addObject(new Sphere(new Vector3D(2, 1, 2), 0.8, Color.RED,90, 0.7,0));
        scene03.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(-2f, 0, 2.0), Color.GREEN ,90,0.8,10));


//ESCENA 4-----------------------------------------------------------------------
        Scene scene04 = new Scene();
        scene04.setCamera(new Camera(new Vector3D(0, 0, -4), 60, 60, 500, 500, 0.6, 50.0));

        scene04.addLight(new PointLight(new Vector3D(2.0, 1.0, 0.0), Color.WHITE, 1.0));
        scene04.addLight(new PointLight(new Vector3D(-2.0, 1.0, 0.0), Color.WHITE, 1.0));
        scene04.addLight(new PointLight(new Vector3D(0, 2.5, 0.0), Color.WHITE, 1.0));
        scene04.addLight(new PointLight(new Vector3D(0, 2, -2.0), Color.WHITE, 1.0));


        scene04.addObject(OBJReader.getModel3D("Plano.obj", new Vector3D(0f, -1.0, 0.0), Color.WHITE, 90, 0,0));
        scene04.addObject(OBJReader.getModel3D("PlanoVertical2.obj", new Vector3D(0f, 0.0, 9), Color.white, 90, 0,0));

        scene04.addObject(OBJReader.getModel3D("CILINDRO1.obj", new Vector3D(0.0, -0.5, -0.5), Color.MAGENTA, 90, 0.8,10));
        scene04.addObject(new Sphere(new Vector3D(0.0, .3, -0.5), 0.4, Color.RED,90, 0.7,15));
        scene04.addObject(OBJReader.getModel3D("STAR.obj", new Vector3D(0.0, .5, 1), Color.orange, 90, 0,0));
        scene04.addObject(OBJReader.getModel3D("STAR2.obj", new Vector3D(1.5, 1.5, 1.5), Color.orange, 90, 0.8,0));
        scene04.addObject(OBJReader.getModel3D("STAR3.obj", new Vector3D(-1, 0, -1.5), Color.orange, 90, 0.8,0));
        scene04.addObject(OBJReader.getModel3D("STAR3.obj", new Vector3D(-1, 0, 1.5), Color.orange, 90, 0.8,0));
        scene04.addObject(OBJReader.getModel3D("STAR3.obj", new Vector3D(-1, 2, 1.5), Color.orange, 90, 0.8,0));
        scene04.addObject(OBJReader.getModel3D("STAR3.obj", new Vector3D(1, 2, .5), Color.orange, 90, 0.8,0));
        scene04.addObject(OBJReader.getModel3D("STAR3.obj", new Vector3D(1.5, 0, -.5), Color.orange, 90, 0.8,0));
        scene04.addObject(OBJReader.getModel3D("STAR3.obj", new Vector3D(-1.5, 1.5, 0), Color.orange, 90, 0.8,0));

//ESCENA 5-----------------------------------------------------------------------
        Scene scene05 = new Scene();
        scene05.setCamera(new Camera(new Vector3D(0, 0, -4), 60, 60, 800, 800, 0.6, 50.0));

        scene05.addLight(new PointLight(new Vector3D(0.0, 1.5, -1.5),Color.WHITE, 20.0));
        scene05.addLight(new PointLight(new Vector3D(0.0, 2, 2),Color.WHITE, 20.0));
        scene05.addLight(new PointLight(new Vector3D(0.0, 3, 2),Color.WHITE, 20.0));
        scene05.addLight(new PointLight(new Vector3D(0.0, 1, 2),Color.WHITE, 20.0));

        scene05.addLight(new PointLight(new Vector3D(-2.5, 2, 2),Color.WHITE, 20.0));
        scene05.addLight(new PointLight(new Vector3D(2.5, 2, 2),Color.WHITE, 20.0));



        scene05.addObject(OBJReader.getModel3D("Plano.obj", new Vector3D(0f, -1.0, 0.0), Color.CYAN, 90, 0.2,0));
        scene05.addObject(OBJReader.getModel3D("PlanoVertical2.obj", new Vector3D(0f, 0.0, 9), Color.BLUE, 10, 0.2,0));
        scene05.addObject(OBJReader.getModel3D("DONA1.obj", new Vector3D(-2.0, -0.5, -0.5), Color.MAGENTA, 90, 0.5,0));
        scene05.addObject(OBJReader.getModel3D("DONA2.obj", new Vector3D(2.0, -0.5, -0.5), Color.MAGENTA, 90, 0.5,0));
        scene05.addObject(OBJReader.getModel3D("DONA3.obj", new Vector3D(0.0, -0.5, 1), Color.MAGENTA, 90, 0.2,0));



        scene05.addObject(new Sphere(new Vector3D(0.0, -.4, .5), 0.2, Color.blue,90, 0.7,15));
        scene05.addObject(new Sphere(new Vector3D(0.0, 1, .5), 1, Color.yellow,90, 0.7,0));
        scene05.addObject(new Sphere(new Vector3D(-2.5, 1.5, 1.5), .5, Color.yellow,90, 0.7,0));
        scene05.addObject(new Sphere(new Vector3D(2.5, 1.5, 1.5), .5, Color.yellow,90, 0.7,0));

        scene05.addObject(OBJReader.getModel3D("PILAR2.obj", new Vector3D(-2.5, -0.7, 1.5), Color.red, 90, 0.2,1.5));
        scene05.addObject(OBJReader.getModel3D("PILAR2.obj", new Vector3D(2.5, -0.7, 1.5), Color.red, 90, 0.2,1.5));


        image = raytrace(scene04,3); //este cambia
        File outputImage = new File("image23.png");


        try {
            ImageIO.write(image, "png", outputImage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        System.out.println(new Date());

    }




    /**
     * Renders a scene using ray tracing with the specified reflection depth.
     * This method initializes and executes the parallel ray tracing method on the scene.
     *
     * @param scene The scene to be rendered.
     * @param reflectionDepth The depth of reflection to be considered in the ray tracing.
     * @return A BufferedImage containing the rendered scene.
     */
    public static BufferedImage raytrace(Scene scene, int reflectionDepth) {

        ParallelMethod(scene, reflectionDepth );
        return image;
    }


    /**
     * Adds two colors together.
     * @param original The first color.
     * @param otherColor The second color.
     * @return The resulting color.
     */
    public static Color addColor(Color original, Color otherColor) {
        float red = (float) Math.clamp((original.getRed() / 255.0) + (otherColor.getRed() / 255.0), 0.0, 1.0);
        float green = (float) Math.clamp((original.getGreen() / 255.0) + (otherColor.getGreen() / 255.0), 0.0, 1.0);
        float blue = (float) Math.clamp((original.getBlue() / 255.0) + (otherColor.getBlue() / 255.0), 0.0, 1.0);
        return new Color(red, green, blue);
    }

    /**
     * Casts a ray into the scene and finds the closest intersection with the objects.
     * This method iterates through a list of objects to determine the nearest intersection
     * point that meets the specified criteria.
     *
     * @param ray The ray being cast into the scene.
     * @param objects The list of objects to check for intersections.
     * @param caster The object casting the ray, which is excluded from intersection checks (can be null).
     * @param clippingPlanes An array of two doubles specifying the near and far clipping planes (can be null).
     * @return The closest intersection that meets the criteria, or null if no valid intersection is found.
     */
    public static Intersection raycast(Ray ray, List<Object3D> objects, Object3D caster, double[] clippingPlanes) {
        Intersection closestIntersection = null;

        for (int i = 0; i < objects.size(); i++) {
            Object3D currObj = objects.get(i);
            if (caster == null || !currObj.equals(caster)) {
                Intersection intersection = currObj.getIntersection(ray);
                if (intersection != null) {
                    double distance = intersection.getDistance();
                    double intersectionZ = intersection.getPosition().getZ();

                    if (distance >= 0 &&
                            (closestIntersection == null || distance < closestIntersection.getDistance()) &&
                            (clippingPlanes == null || (intersectionZ >= clippingPlanes[0] && intersectionZ <= clippingPlanes[1]))) {
                        closestIntersection = intersection;
                    }
                }
            }
        }

        return closestIntersection;
    }

    /**
     * Calculates the specular reflection intensity at an intersection point.
     * This method computes the specular reflection intensity using the Phong reflection model,
     * considering the viewer's direction, the light source direction, surface normal,
     * and shininess coefficient.
     *
     * @param Viewer The ray representing the viewer's direction.
     * @param light The light source contributing to the reflection.
     * @param shininess The shininess coefficient of the object's surface.
     * @param v The intersection point where the reflection occurs.
     * @return The specular reflection intensity calculated based on the Phong reflection model.
     */
    public static double Calculatespecular(Ray Viewer, Light light, double shininess, Intersection v){
        //resta de la posicion de la interseccion - la posicion de la light source == light direction

        Vector3D light_direction = Vector3D.substract(v.getPosition(), light.getPosition());
        Vector3D halfVector = Vector3D.normalize(Vector3D.add(Viewer.getDirection(),light_direction));
        Vector3D surfaceNormal =v.getNormal();
        double specular = Math.pow(Vector3D.dotProduct(surfaceNormal, halfVector), shininess);

        return specular;
    }
    /**
     * Computes the reflection direction vector based on the incident direction and surface normal.
     * This method calculates the reflection direction vector using the incident direction
     * and the surface normal at the intersection point.
     *
     * @param direction The incident direction vector.
     * @param normal The surface normal vector at the intersection point.
     * @return The reflection direction vector computed based on the incident direction and surface normal.
     */
    public static Vector3D reflect(Vector3D direction, Vector3D normal) {
        double dotProduct = Vector3D.dotProduct(direction, normal);
        return Vector3D.substract(direction, Vector3D.scalarMultiplication(normal, 2 * dotProduct));
    }

    /**
     * Renders the scene using parallel processing.
     * This method utilizes parallel processing to render the scene by distributing
     * the ray tracing computations across multiple threads.
     *
     * @param scene The scene to be rendered.
     * @param reflectionDepth The maximum depth of reflection rays to trace.
     */
    public static void ParallelMethod(Scene scene, int reflectionDepth){
        ExecutorService executorService = Executors.newFixedThreadPool(8);

        Camera mainCamera = scene.getCamera();
        double[] nearFarPlanes = mainCamera.getNearFarPlanes();
        image = new BufferedImage(mainCamera.getResolutionWidth(), mainCamera.getResolutionHeight(), BufferedImage.TYPE_INT_RGB);
        List<Object3D> objects = scene.getObjects();
        List<Light> lights = scene.getLights();
        Vector3D[][] posRaytrace = mainCamera.calculatePositionsToRay();
        Vector3D pos = mainCamera.getPosition();
        double cameraZ = pos.getZ();

        for (int i = 0; i < posRaytrace.length; i++) {
            for (int j = 0; j < posRaytrace[i].length; j++) {

                double x = posRaytrace[i][j].getX() + pos.getX();
                double y = posRaytrace[i][j].getY() + pos.getY();
                double z = posRaytrace[i][j].getZ() + pos.getZ();

                Ray ray = new Ray(mainCamera.getPosition(), new Vector3D(x, y, z));//PARA
                Runnable runnable = draw(i,j,ray, objects, lights, null, cameraZ, nearFarPlanes, reflectionDepth);
                executorService.execute(runnable);

            }
        }
        System.out.println(new Date());
        executorService.shutdown();

        try{
            if(!executorService.awaitTermination(60, TimeUnit.MINUTES)){
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            if(!executorService.isTerminated()){
                System.err.println("Cancel non-finished");
            }
        }
        executorService.shutdownNow();
    }

    /**
     * Creates a Runnable task for drawing a pixel in the image.
     * This method generates a Runnable task that calculates the color of a pixel
     * based on the intersection of a ray with objects in the scene, and sets the
     * corresponding color in the image.
     *
     * @param i The row index of the pixel in the image.
     * @param j The column index of the pixel in the image.
     * @param ray The ray corresponding to the pixel.
     * @param objects The list of 3D objects in the scene.
     * @param lights The list of lights in the scene.
     * @param caster The object casting the ray (can be null).
     * @param cameraZ The z-coordinate of the camera position.
     * @param nearFarPlanes The near and far clipping planes of the camera.
     * @param reflectionDepth The maximum depth of reflection rays to trace.
     * @return A Runnable task for drawing the pixel.
     */
    public static Runnable draw (int i, int j, Ray ray, List<Object3D> objects, List<Light> lights , Object3D caster, double cameraZ,  double[] nearFarPlanes, int reflectionDepth){
        Runnable aRunnable = new Runnable() {
            @Override
            public void run() {
                Color pixelColor = decideColor(ray, objects, lights, null, cameraZ, nearFarPlanes, reflectionDepth);
                setRGB(i, j, pixelColor);
            }
        };


        return aRunnable;
    }

    /**
     * Determines the color of a pixel based on the intersection of a ray with objects in the scene.
     * This method calculates the color of a pixel by simulating lighting effects such as diffuse and specular reflections,
     * shadows, and optionally, reflection and refraction.
     *
     * @param ray The ray corresponding to the pixel.
     * @param objects The list of 3D objects in the scene.
     * @param lights The list of lights in the scene.
     * @param caster The object casting the ray (can be null).
     * @param cameraZ The z-coordinate of the camera position.
     * @param nearFarPlanes The near and far clipping planes of the camera.
     * @param reflectionDepth The maximum depth of reflection rays to trace.
     * @return The color of the pixel.
     */
    public static Color decideColor(Ray ray, List<Object3D> objects, List<Light> lights, Object3D caster, double cameraZ, double[] nearFarPlanes, int reflectionDepth){

        Intersection closestIntersection = raycast(ray, objects, caster, new double[]{cameraZ + nearFarPlanes[0], cameraZ + nearFarPlanes[1]});
        Color pixelColor = Color.BLACK;

        if (closestIntersection != null) {
            Color objColor = closestIntersection.getObject().getColor();
            double reflectivity = closestIntersection.getObject().getReflectivity();
            double refractiveIndex = closestIntersection.getObject().getRefraction();


            // Componente de iluminación difusa y especular
            for (Light light : lights) {
                Vector3D lightDirection = Vector3D.substract(light.getPosition(), closestIntersection.getPosition());
                Ray detectShadow = new Ray(closestIntersection.getPosition(), lightDirection); //CAMBIO1
                Intersection shadowIntersection = raycast(detectShadow, objects, closestIntersection.getObject(), new double[]{cameraZ + nearFarPlanes[0], cameraZ + nearFarPlanes[1]});

                if (shadowIntersection != null) {
                    // El pixel está en sombra, no añadir luz difusa o especular
                    continue;
                }

                double nDotL = light.getNDotL(closestIntersection);
                Color lightColor = light.getColor();
                double intensity = light.getIntensity() * nDotL;

                if (light instanceof PointLight) {
                    intensity = intensity / Math.pow(closestIntersection.getDistance(), 1);
                }

                double specular = Calculatespecular(ray, light, closestIntersection.getObject().getShininess(), closestIntersection);

                double[] lightColors = new double[]{lightColor.getRed() / 255.0, lightColor.getGreen() / 255.0, lightColor.getBlue() / 255.0};
                double[] objColors = new double[]{objColor.getRed() / 255.0, objColor.getGreen() / 255.0, objColor.getBlue() / 255.0};
                for (int colorIndex = 0; colorIndex < objColors.length; colorIndex++) {
                    objColors[colorIndex] *= intensity * lightColors[colorIndex];
                }

                Color diffuse = new Color(
                        (float) Math.clamp(objColors[0], 0.0, 1.0),
                        (float) Math.clamp(objColors[1], 0.0, 1.0),
                        (float) Math.clamp(objColors[2], 0.0, 1.0));

                pixelColor = addColor(pixelColor, diffuse);

                Color specularColor = new Color(
                        (float) Math.clamp(light.getColor().getRed() / 255.0 * specular, 0.0, 1.0),
                        (float) Math.clamp(light.getColor().getGreen() / 255.0 * specular, 0.0, 1.0),
                        (float) Math.clamp(light.getColor().getBlue() / 255.0 * specular, 0.0, 1.0));

                pixelColor = addColor(pixelColor, specularColor);
            }

            if (reflectionDepth > 0 && reflectivity > 0) {
                Vector3D reflectionDirection = reflect(ray.getDirection(), closestIntersection.getNormal());
                Ray reflectionRay = new Ray(closestIntersection.getPosition(), reflectionDirection);
                Color reflectionColor = decideColor(reflectionRay, objects, lights, closestIntersection.getObject(), cameraZ, nearFarPlanes, reflectionDepth - 1);
                reflectionColor = scaleColor(reflectionColor, reflectivity);
                pixelColor = addColor(scaleColor(pixelColor, 1 - reflectivity), reflectionColor); //CAMBIO2 - este es el de la sombra blanca
            }

            if (reflectionDepth > 0 && refractiveIndex > 0) {
                Vector3D normal = closestIntersection.getNormal();
                Vector3D incident = ray.getDirection();
                double n1 = 1.0;
                double n2 = refractiveIndex;
                Vector3D refractDirection = refract(incident, normal, n1, n2);
                if (refractDirection != null) {
                    Ray refractRay = new Ray(closestIntersection.getPosition(), refractDirection);
                    Color refractionColor = decideColor(refractRay, objects, lights, closestIntersection.getObject(), cameraZ, nearFarPlanes, reflectionDepth - 1);
                    pixelColor = addColor(pixelColor, scaleColor(refractionColor, 1 - reflectivity));
                }
            }

        }

        return pixelColor;
    };

    /**
     * Scales the given color by the specified factor.
     *
     * @param color The color to scale.
     * @param scale The scaling factor.
     * @return The scaled color.
     */
    public static Color scaleColor(Color color, double scale) {
        return new Color(
                (float) Math.clamp(color.getRed() / 255.0 * scale, 0.0, 1.0),
                (float) Math.clamp(color.getGreen() / 255.0 * scale, 0.0, 1.0),
                (float) Math.clamp(color.getBlue() / 255.0 * scale, 0.0, 1.0)
        );
    }

    /**
     * Calculates the refraction direction vector based on the incident vector, surface normal, and refractive indices.
     *
     * @param incident The incident vector.
     * @param normal The surface normal vector.
     * @param n1 The refractive index of the medium the ray is coming from.
     * @param n2 The refractive index of the medium the ray is entering.
     * @return The refracted direction vector, or null if total internal reflection occurs.
     */
    public static Vector3D refract(Vector3D incident, Vector3D normal, double n1, double n2) {
        double refractiveRatio = n1 / n2;
        double cosIncident = -Vector3D.dotProduct(normal, incident);
        double sinTransmissionSquare = refractiveRatio * refractiveRatio * (1 - cosIncident * cosIncident);
        if (sinTransmissionSquare > 1.0) {
            return null;
        }
        double cosTransmission = Math.sqrt(1.0 - sinTransmissionSquare);
        return Vector3D.add(
                Vector3D.scalarMultiplication(incident, refractiveRatio),
                Vector3D.scalarMultiplication(normal, refractiveRatio * cosIncident - cosTransmission)
        );
    }

    /**
     * Sets the RGB color of a pixel in the image at the specified coordinates.
     * This method is thread-safe and synchronized.
     *
     * @param i The x-coordinate of the pixel.
     * @param j The y-coordinate of the pixel.
     * @param pixelColor The color to set for the pixel.
     */
    public static synchronized void setRGB(int i, int j, Color pixelColor){
        image.setRGB(i, j, pixelColor.getRGB());
    };


}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesine.ipm.imageSample.util;

import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

/**
 *
 * @author julioa
 */
public class ImageUtil {

    public static Image resizeImage(Image image, int thumbHeight, int thumbWidth) {
        int srcWidth = image.getWidth();
        int srcHeight = image.getHeight();

        int newWidth = 64;
        int newHeight = -1;

        if (thumbHeight == -1) {
            newHeight = thumbWidth * srcHeight / srcWidth;
        }

        Image newImage = Image.createImage(newWidth, newHeight);
        Graphics g = newImage.getGraphics();

        for (int y = 0; y < newHeight; y++) {
            for (int x = 0; x < newWidth; x++) {
                g.setClip(x, y, 1, 1);
                int dx = x * srcWidth / newWidth;
                int dy = y * srcHeight / newHeight;
                g.drawImage(image, x - dx, y - dy,
                        Graphics.LEFT | Graphics.TOP);
            }
        }

        Image immutableImage = Image.createImage(newImage);

        return immutableImage;
    }

    /**
     * This methog resizes an image by resampling its pixels
     * @param src The image to be resized
     * @return The resized image
     */
    public static Image resizeImage2(Image src, int screenWidth, int screenHeight) {
        int srcWidth = src.getWidth();
        int srcHeight = src.getHeight();
        Image tmp = Image.createImage(screenWidth, srcHeight);
        Graphics g = tmp.getGraphics();
        int ratio = (srcWidth << 16) / screenWidth;
        int pos = ratio / 2;

        //Horizontal Resize

        for (int x = 0; x < screenWidth; x++) {
            g.setClip(x, 0, 1, srcHeight);
            g.drawImage(src, x - (pos >> 16), 0, Graphics.LEFT | Graphics.TOP);
            pos += ratio;
        }

        Image resizedImage = Image.createImage(screenWidth, screenHeight);
        g = resizedImage.getGraphics();
        ratio = (srcHeight << 16) / screenHeight;
        pos = ratio / 2;

        //Vertical resize

        for (int y = 0; y < screenHeight; y++) {
            g.setClip(0, y, screenWidth, 1);
            g.drawImage(tmp, 0, y - (pos >> 16), Graphics.LEFT | Graphics.TOP);
            pos += ratio;
        }
        return resizedImage;

    }//resize image

    /**
     * This methog resizes an image by resampling its pixels
     * @param src The image to be resized
     * @return The resized image
     */
    public static Image resizeImage3(Image src, int screenWidth, int screenHeight) {
        int srcWidth = src.getWidth();
        int srcHeight = src.getHeight();



        float porcX = (float) screenWidth / (float) srcWidth;
        float porcY = (float) screenHeight / (float) srcHeight;

        float porcFinal = Math.min(porcX, porcY);

        int finalWidth = (int) (srcWidth * porcFinal);
        int finalHeight = (int) (srcHeight * porcFinal);

        System.out.println(finalWidth + "x" + finalHeight);

        Image tmp = Image.createImage(finalWidth, srcHeight);
        Graphics g = tmp.getGraphics();
        int ratio = (srcWidth << 16) / finalWidth;
        int pos = ratio / 2;

        //Horizontal Resize

        for (int x = 0; x < finalWidth; x++) {
            g.setClip(x, 0, 1, srcHeight);
            g.drawImage(src, x - (pos >> 16), 0, Graphics.LEFT | Graphics.TOP);
            pos += ratio;
        }

        Image resizedImage = Image.createImage(finalWidth, finalHeight);
        g = resizedImage.getGraphics();
        ratio = (srcHeight << 16) / finalHeight;
        pos = ratio / 2;

        //Vertical resize

        for (int y = 0; y < finalHeight; y++) {
            g.setClip(0, y, finalWidth, 1);
            g.drawImage(tmp, 0, y - (pos >> 16), Graphics.LEFT | Graphics.TOP);
            pos += ratio;
        }
        return resizedImage;

    }//resize image

    public static int[] reescalaArray(int[] ini, int x, int y, int x2, int y2) {
        int out[] = new int[x2 * y2];
        for (int yy = 0; yy < y2; yy++) {
            int dy = yy * y / y2;
            for (int xx = 0; xx < x2; xx++) {
                int dx = xx * x / x2;
                out[(x2 * yy) + xx] = ini[(x * dy) + dx];
            }
        }
        return out;
    }

    public static void rescaleImage(int newX, int newY) {
        //Need an image
        Image temp = null;
        try {
            temp = Image.createImage("/tr1.gif");
        } catch (IOException e) {
            System.err.println("Can`t load the image : " + e.toString());
        }
//Need an array (for RGB, with the size of original image)
        int rgb[] = new int[temp.getWidth() * temp.getHeight()];
//Get the RGB array of image into "rgb"
        temp.getRGB(rgb, 0, temp.getWidth(), 0, 0, temp.getWidth(), temp.getHeight());
//Call to our function and obtain RGB2
        int rgb2[] = reescalaArray(rgb, temp.getWidth(), temp.getHeight(), newX, newY);
//Create an image with that RGB array
        Image temp2 = Image.createRGBImage(rgb2, newX, newY, true);
    }

    public static Image rotateImage(Image image, int angle) throws Exception {
        if (angle == 0) {
            return image;
        } else if (angle != 180 && angle != 90 && angle != 270) {
            throw new Exception("Invalid angle");
        }

        int width = image.getWidth();
        int height = image.getHeight();

        int[] rowData = new int[width];
        int[] rotatedData = new int[width * height];

        int rotatedIndex = 0;

        for (int i = 0; i < height; i++) {
            image.getRGB(rowData, 0, width, 0, i, width, 1);

            for (int j = 0; j < width; j++) {
                rotatedIndex =
                        angle == 90 ? (height - i - 1) + j * height
                        : (angle == 270 ? i + height * (width - j - 1)
                        : width * height - (i * width + j) - 1);

                rotatedData[rotatedIndex] = rowData[j];
            }
        }

        if (angle == 90 || angle == 270) {
            return Image.createRGBImage(rotatedData, height, width, true);
        } else {
            return Image.createRGBImage(rotatedData, width, height, true);
        }
    }

    // Tomado de http://www.java-tips.org/java-me-tips/midp/how-to-implement-zoom-in-and-zoom-out.html
    public Image ZoomIn(Image img) {

        Image outImg = null;
        int[] rgbOutput = null;

        Graphics g = null;
        int width = 0, height = 0;

        try {

            width = img.getWidth();
            height = img.getHeight();
            outImg = Image.createImage(height, width);
            int rgbInput[] = new int[width * height];
            rgbOutput = new int[width * height];
            img.getRGB(rgbInput, 0, width, 0, 0, width, height);

            int i, j, k, l;
            k = 0;
            int tempArr[][] = new int[height][width];

            for (i = 0; i < height; i++) {
                for (j = 0; j < width; j++) {
                    tempArr[i][j] = rgbInput[k++];
                }
            }

            k = 0;
            for (i = 0; i < height; i++) {
                for (j = 0; j < width; j++) {
                    rgbOutput[k] = tempArr[j][i];
                    k++;
                }
            }
            g = outImg.getGraphics();

        } catch (Exception e) {
        }

        return outImg.createRGBImage(rgbOutput, height, width, true);
    }

    public Image zoomImage(Image img) {

        Image outImg = null;

        int[] rgbOutput = null;
        Graphics g = null;
        int width = 0, height = 0;

        try {

            width = img.getWidth();
            height = img.getHeight();

            outImg = Image.createImage(width << 1, height << 1);

            int rgbInput[] = new int[width * height];
            rgbOutput = new int[(width << 1) * (height << 1)];

            img.getRGB(rgbInput, 0, width, 0, 0, width, height);

            int i, j, k;
            k = 0;
            for (i = 0; i < (height << 1); i += 2) {
                for (j = 0; j < (width << 1); j += 2) {
                    rgbOutput[i * (width << 1) + j] = rgbInput[k];
                    rgbOutput[(i + 1) * (width << 1) + j] = rgbInput[k];
                    rgbOutput[i * (width << 1) + j + 1] = rgbInput[k];
                    rgbOutput[(i + 1) * (width << 1) + j + 1] = rgbInput[k];
                    k++;
                }
            }

            g = outImg.getGraphics();
        } catch (Exception e) {
        }

        return outImg.createRGBImage(rgbOutput, width << 1, height << 1, true);
    }
}

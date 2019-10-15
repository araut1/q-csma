/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package qcsma;

import java.io.*;

import org.jfree.data.xy.*;
import org.jfree.data.*;
import org.jfree.chart.renderer.category.*;
import org.jfree.chart.plot.*;
import java.awt.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;


public class graph_view{

    public static int v1,v2;

    public graph_view(int v,int vs){
        v1=v;
        v2=vs;
    }

    public static void main(String arg[]){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        System.out.println("get value"+v1);
        System.out.println("put value"+v2);
        dataset.setValue(v1, "Transmission time", "Traditional");
        dataset.setValue(v2, "Transmission time", "Proposed");

        JFreeChart chart = ChartFactory.createBarChart("Transmission ","Techniques", "Time in Percentage", dataset,PlotOrientation.VERTICAL, false,true, false);
        chart.setBackgroundPaint(Color.yellow);
        chart.getTitle().setPaint(Color.blue);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.red);
        ChartFrame frame1=new ChartFrame("Performance Evaluation",chart);
        frame1.setVisible(true);
        frame1.setSize(400,350);
    }
}


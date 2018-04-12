package fun.peri.controller;

import fun.peri.service.IFinancialService;
import org.jfree.chart.*;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.RectangleInsets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

@Controller
@RequestMapping(value = "/finanical")
public class BarChart3DDemo {

    @Autowired
    private IFinancialService financialService;

    /**
     * 画统计图
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/fufu")
    public String fufu(HttpServletRequest request, ModelMap map) {
        String daytime = request.getParameter("daytime");
        String productname = request.getParameter("productname");
        List<Object[]> lists = null;
        if ((daytime == null) && (productname == null)) {
            lists = financialService.queryFinancial();
        } else
            lists = financialService.queryByDay(daytime, productname);
        map.put("lists", lists);
        barchart(request, lists);
        linechart(request, lists);
        piechart(request, lists);
        return "forward:/admin/jsp/financial/date_statistics.jsp";
    }

    /**
     * 画柱状图
     *
     * @param request
     * @param listss
     */
    public void barchart(HttpServletRequest request, List<Object[]> listss) {
        try {
            // 构造数据
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            List<Object[]> lists = listss;
            for (Object[] list : lists) {
                dataset.addValue(Double.parseDouble(list[3].toString()), list[1].toString(), list[1].toString());
            }
            StandardChartTheme mChartTheme = new StandardChartTheme("unicode");
            mChartTheme.setExtraLargeFont(new Font("黑体", Font.BOLD, 20));
            mChartTheme.setLargeFont(new Font("宋体", Font.CENTER_BASELINE, 15));
            mChartTheme.setRegularFont(new Font("宋体", Font.CENTER_BASELINE, 15));
            ChartFactory.setChartTheme(mChartTheme);
            // 设置宽度
            JFreeChart chart = ChartFactory.createBarChart3D("财务统计条形图", "产品名称", "总收入(元)", dataset,
                    PlotOrientation.VERTICAL, true, false, false);
            CategoryPlot plot = chart.getCategoryPlot();
            CategoryAxis domainAxis = plot.getDomainAxis();
            domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
            int k = dataset.getColumnCount();
            if (k == 1) {
                plot.getDomainAxis().setLowerMargin(0.26);
                plot.getDomainAxis().setUpperMargin(0.66);
            } else if (k < 6) {
                double margin = (1.0 - k * 0.08) / 3;
                plot.getDomainAxis().setLowerMargin(margin);
                plot.getDomainAxis().setUpperMargin(margin);
            }

            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPopupMenu(null);
            // 服务器路径
            String url = request.getRealPath("/chartimages");
            // 保存图表

            ChartUtilities.saveChartAsPNG(new File(url, "BarChart3D.png"), chart, 500, 400);
            request.setAttribute("barchart", "BarChart3D.png");
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return;
    }

    /**
     * 画折线状图
     *
     * @param request
     * @param listss
     */
    public void linechart(HttpServletRequest request, List<Object[]> listss) {
        try {
            // 构造数据
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            List<Object[]> lists = listss;
            for (Object[] list : lists) {
                dataset.addValue(Double.parseDouble(list[3].toString()), list[1].toString(), list[1].toString());
            }
            StandardChartTheme mChartTheme = new StandardChartTheme("unicode");
            mChartTheme.setExtraLargeFont(new Font("黑体", Font.BOLD, 20));
            mChartTheme.setLargeFont(new Font("宋体", Font.CENTER_BASELINE, 15));
            mChartTheme.setRegularFont(new Font("宋体", Font.CENTER_BASELINE, 15));
            ChartFactory.setChartTheme(mChartTheme);
            // 设置宽度
            JFreeChart chart = ChartFactory.createLineChart("财务统计折线图", "产品名称", "总收入(元)", dataset,
                    PlotOrientation.VERTICAL, true, true, true);
            CategoryPlot categoryPlot = (CategoryPlot) chart.getPlot();
            categoryPlot.setAxisOffset(new RectangleInsets(0D, 0D, 10D, 10D));
            LineAndShapeRenderer lineAndShapeRenderer = (LineAndShapeRenderer) categoryPlot.getRenderer();
            lineAndShapeRenderer.setBaseShapesVisible(true);
            lineAndShapeRenderer.setDrawOutlines(true);
            // lineAndShapeRenderer.setBaseItemLabelGenerator(new
            // StandardCategoryItemLabelGenerator());
            // lineAndShapeRenderer.setUseFillPaint(true);
            // lineAndShapeRenderer.setBaseFillPaint(Color.white);
            lineAndShapeRenderer.setSeriesStroke(0, new BasicStroke(3F));
            lineAndShapeRenderer.setSeriesOutlineStroke(0, new BasicStroke(2.0F));
            CategoryAxis domainAxis = categoryPlot.getDomainAxis();
            domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
            ChartPanel chartPanel = new ChartPanel(chart, true);
            chartPanel.setPopupMenu(null);
            // 服务器路径
            String url = request.getRealPath("/chartimages");
            // 保存图表
            ChartUtilities.saveChartAsPNG(new File(url, "lineChart3D.png"), chart, 500, 400);
            request.setAttribute("linechart", "lineChart3D.png");
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return;
    }

    /**
     * 饼状图
     *
     * @param request
     * @param listss
     */
    public void piechart(HttpServletRequest request, List<Object[]> listss) {
        try {
            // 构造数据
            DefaultPieDataset dataset = new DefaultPieDataset();
            List<Object[]> lists = listss;
            for (Object[] list : lists) {
                dataset.setValue(list[1].toString(), Double.parseDouble(list[3].toString()));
            }
            StandardChartTheme mChartTheme = new StandardChartTheme("unicode");
            mChartTheme.setExtraLargeFont(new Font("黑体", Font.BOLD, 20));
            mChartTheme.setLargeFont(new Font("宋体", Font.CENTER_BASELINE, 15));
            mChartTheme.setRegularFont(new Font("宋体", Font.CENTER_BASELINE, 15));
            ChartFactory.setChartTheme(mChartTheme);
            // 设置宽度
            JFreeChart chart = ChartFactory.createPieChart3D("财务统计饼状图", (PieDataset) dataset, true, false, false);
            // 设置百分比
            PiePlot pieplot = (PiePlot) chart.getPlot();
            // 设置小数点
            DecimalFormat df = new DecimalFormat("0.00%");
            NumberFormat nf = NumberFormat.getNumberInstance();
            StandardPieSectionLabelGenerator sp1 = new StandardPieSectionLabelGenerator("{0} {2}", nf, df);
            pieplot.setLabelGenerator(sp1);

            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPopupMenu(null);
            // 服务器路径
            String url = request.getRealPath("/chartimages");
            // 保存图表
            ChartUtilities.saveChartAsPNG(new File(url, "pieChart3D.png"), chart, 400, 400);
            request.setAttribute("piechart", "pieChart3D.png");
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

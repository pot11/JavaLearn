package p21;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.properties.TextAlignment;

import java.io.IOException;

public class StandardChinesePDFGenerator {
    private PdfFont simSunFont; // 宋体
    private PdfFont simHeiFont;  // 黑体

    public StandardChinesePDFGenerator(String simSunPath, String simHeiPath) throws IOException {
        // 加载宋体和黑体字体
        this.simSunFont = PdfFontFactory.createFont(simSunPath, PdfEncodings.IDENTITY_H);
        this.simHeiFont = PdfFontFactory.createFont(simHeiPath, PdfEncodings.IDENTITY_H);
    }

    public void createPDF(String title, String content, String outputPath) throws IOException {
        // 创建PDF文档 - A4纵向
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(outputPath));
        Document doc = new Document(pdfDoc, PageSize.A4);

        // 设置页面边距: 上2.54cm/下2.54cm/左3.17cm/右2.54cm
        // 1cm = 28.35pt
        float topMargin = 2.54f * 28.35f;
        float bottomMargin = 2.54f * 28.35f;
        float leftMargin = 3.17f * 28.35f;
        float rightMargin = 2.54f * 28.35f;

        doc.setMargins(topMargin, rightMargin, bottomMargin, leftMargin);

        // 添加主标题
        Paragraph titlePara = new Paragraph(title)
                .setFont(simHeiFont)        // 黑体
                .setFontSize(16)            // 三号(16pt)
                .setBold()                  // 加粗
                .setTextAlignment(TextAlignment.CENTER) // 居中
                .setMarginTop(12 * 1.5f)    // 段前1行 (12pt * 1.5倍行距)
                .setMarginBottom(6 * 1.5f); // 段后0.5行 (6pt * 1.5倍行距)
        doc.add(titlePara);

        // 处理正文内容
        String[] paragraphs = content.split("\n");

        for (String paraText : paragraphs) {
            if (paraText.trim().isEmpty()) {
                continue; // 跳过空行
            }

            // 创建段落
            Paragraph paragraph = new Paragraph();
            paragraph.setFont(simSunFont);          // 宋体
            paragraph.setFontSize(12);              // 小四(12pt)
            paragraph.setMultipliedLeading(1.5f);   // 1.5倍行距

            // 设置文本对齐方式：两端对齐
            paragraph.setTextAlignment(TextAlignment.JUSTIFIED);

            paragraph.setFirstLineIndent(24);       // 首行缩进2字符 (12pt * 2)
            paragraph.setMarginTop(0);              // 段前0
            paragraph.setMarginBottom(0);           // 段后0

            // 添加段落文本
            paragraph.add(paraText);

            doc.add(paragraph);
        }

        doc.close();
        System.out.println("PDF已生成: " + outputPath);
    }

    public static void main(String[] args) {
        try {
            // 使用SimSun和SimHei字体
            String simSunPath = "/Users/zen/develop/IdeaProjects/JavaLearn/practice/src/main/java/p21/simsun.ttf";
            String simHeiPath = "/Users/zen/develop/IdeaProjects/JavaLearn/practice/src/main/java/p21/simhei.ttf";

            StandardChinesePDFGenerator generator = new StandardChinesePDFGenerator(simSunPath, simHeiPath);

            // 示例文章内容
            String articleTitle = "人工智能的现状与未来发展";
            String articleContent = "我国高铁经过数十年的沧桑发展，现在早已成为世界上的一张靓丽中国名片。但近日，有网友发文质疑二等座和无座票同价的行为是否真的合理，虽然12306工作人员已经给出具体回应，但仍引发热议。由此可见，重要的并非是理由能否被理解，而是在大众理解之上有没有主动解决公共服务问题。\n" +
                    "高铁部门在票价决策中确实蕴含着复杂的现实考量。一般购买无座票的往往是紧急或必须出行的人群，例如春运和大型节假日，或遇其他紧急情况出行的人。这个时候人们多半更在意行程问题而非票价问题。无座票本身就是为了满足特定人群的出行需求才设立的，再加上车厢、线路都一样，乘客享受到了同样的车辆运行、线路维护等基础服务，按全程成本均摊费用也无可厚非。这同时还避免了因定价不同而导致的日常期间因票价不同而管理混乱的问题。\n" +
                    "回应公众不如理解公众。选择无座也不一定是乘客个人原因，还存在高铁在高峰期承载力不足的情况。明明一样的价格却享受不到同样的服务，使得很多人心里不平衡；一路上遇到空座位才敢坐一小会儿，遇到原坐乘客出现，还得起身连连抱歉，也让很多人心生委屈。这种不平衡和委屈说到底并不是价格问题，而是尊严感和公平感的缺失。对于铁路企业而言，最重要的，是从多元需求中找到最大公约数，提供更人性化的服务，真正理解公众，才能逐步根治问题。\n" +
                    "更何况，高铁票价之困并非无路可走。其实，高铁部门一旦理解了公众内心不公平感的来源，相应的政策便会随之而来。例如，可以设置分时间段阶梯票价供不同需求的人们选择；或在车厢设立固定的爱心无座票座位，为老人、孕妇等特殊人群提供便利。这样的措施不仅缓解高铁高峰期压力，更体现人文关怀。\n" +
                    "服务的核心在于以人为本。这不是抽象的概念或者漂亮的口号，而是藏在每一次和公众的接触、政策的制定和服务细节中。唯有将这种关怀深深融入高铁的血脉，才能真正从根源解决问题，让高铁的发展与公众的满意同行。";

            // 生成PDF
            String outputFile = "/Users/zen/develop/front/standard_article.pdf";
            generator.createPDF(articleTitle, articleContent, outputFile);

        } catch (Exception e) {
            System.err.println("生成PDF时出错: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

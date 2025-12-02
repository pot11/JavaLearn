package p21;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArticleToPDFConverter {

    // 页面尺寸和边距
    private static final PDRectangle PAGE_SIZE = PDRectangle.A4;
    private static final float MARGIN = 72; // 1英寸 = 72点
    private static final float TITLE_FONT_SIZE = 18;
    private static final float BODY_FONT_SIZE = 12;
    private static final float LINE_SPACING = 1.5f;

    private PDFont titleFont;
    private PDFont bodyFont;

//    public ArticleToPDFConverter() {
//        // 使用默认字体
//        this.titleFont = PDType1Font.HELVETICA_BOLD;
//        this.bodyFont = PDType1Font.HELVETICA;
//    }

    // 使用中文字体的构造函数
    public ArticleToPDFConverter(String titleFontPath, String bodyFontPath) throws IOException {
        try (PDDocument document = new PDDocument()) {
            this.titleFont = PDType0Font.load(document, new File(titleFontPath));
            this.bodyFont = PDType0Font.load(document, new File(bodyFontPath));
        }
    }

    public void convertToPDF(String title, String content, String outputPath) throws IOException {
        PDDocument document = new PDDocument(); // 手动创建，不使用 try-with-resources
        PDPageContentStream contentStream = null;

        try {
//            // 加载字体（与当前document绑定）
//            PDFont titleFont, bodyFont;
//            if (useChineseFont) {
//                titleFont = loadFont(document, titleFontPath);
//                bodyFont = loadFont(document, bodyFontPath);
//            } else {
//                titleFont = PDType1Font.HELVETICA_BOLD;
//                bodyFont = PDType1Font.HELVETICA;
//            }
            String simSunPath = "/Users/zen/develop/IdeaProjects/JavaLearn/practice/src/main/java/p21/SimSun.ttf";
            this.titleFont = PDType0Font.load(document, new File(simSunPath));
            this.bodyFont = PDType0Font.load(document, new File(simSunPath));
            PDPage page = new PDPage(PAGE_SIZE);
            document.addPage(page);

            // 计算可用宽度和起始Y坐标
            float width = PAGE_SIZE.getWidth() - 2 * MARGIN;
            float startY = PAGE_SIZE.getHeight() - MARGIN;

            contentStream = new PDPageContentStream(document, page);

            // 设置标题
            contentStream.setFont(titleFont, TITLE_FONT_SIZE);
            float titleWidth = titleFont.getStringWidth(title) / 1000 * TITLE_FONT_SIZE;
            float titleX = (PAGE_SIZE.getWidth() - titleWidth) / 2;
            contentStream.beginText();
            contentStream.newLineAtOffset(titleX, startY - 30);
            contentStream.showText(title);
            contentStream.endText();

            // 计算正文起始位置
            float currentY = startY - TITLE_FONT_SIZE - 60;

            // 处理正文段落
            String[] paragraphs = content.split("\n");
            contentStream.setFont(bodyFont, BODY_FONT_SIZE);

            for (String paragraph : paragraphs) {
                if (paragraph.trim().isEmpty()) {
                    currentY -= BODY_FONT_SIZE * LINE_SPACING;
                    continue;
                }

                // 分割段落为多行
                List<String> lines = splitTextIntoLines(paragraph, bodyFont, BODY_FONT_SIZE, width);

                for (String line : lines) {
                    if (currentY < MARGIN) {
                        // 关闭当前内容流并创建新页面
                        if (contentStream != null) {
                            contentStream.close();
                        }
                        page = new PDPage(PAGE_SIZE);
                        document.addPage(page);
                        contentStream = new PDPageContentStream(document, page);
                        contentStream.setFont(bodyFont, BODY_FONT_SIZE);
                        currentY = PAGE_SIZE.getHeight() - MARGIN;
                    }

                    contentStream.beginText();
                    contentStream.newLineAtOffset(MARGIN, currentY);
                    contentStream.showText(line);
                    contentStream.endText();

                    currentY -= BODY_FONT_SIZE * LINE_SPACING;
                }

                // 段落间距
                currentY -= BODY_FONT_SIZE * 0.5f;
            }

            // 关闭最后一个内容流
            if (contentStream != null) {
                contentStream.close();
            }

            // 保存文档
            document.save(outputPath);
        } finally {
            // 确保资源被正确释放
            if (document != null) {
                try {
                    document.close();
                } catch (IOException e) {
                    // 记录日志但不抛出异常
                    System.err.println("关闭文档时出错: " + e.getMessage());
                }
            }
        }

        System.out.println("PDF已生成: " + outputPath);
    }

    /**
     * 将文本分割为适合页面宽度的多行
     */
    private List<String> splitTextIntoLines(String text, PDFont font, float fontSize, float width) throws IOException {
        List<String> lines = new ArrayList<>();
        if (text == null || text.isEmpty()) {
            return lines;
        }

        String[] words = text.split(" ");
        StringBuilder currentLine = new StringBuilder();

        for (String word : words) {
            String testLine = currentLine.length() > 0 ? currentLine.toString() + " " + word : word;
            float testWidth = font.getStringWidth(testLine) / 1000 * fontSize;

            if (testWidth > width && currentLine.length() > 0) {
                lines.add(currentLine.toString());
                currentLine = new StringBuilder(word);
            } else {
                currentLine.append(currentLine.length() > 0 ? " " + word : word);
            }
        }

        if (currentLine.length() > 0) {
            lines.add(currentLine.toString());
        }

        return lines;
    }

    // 使用示例
    public static void main(String[] args) {
        try {
//            // 使用苹方字体
//            String pingFangPath = "/System/Library/Fonts/PingFang.ttc";
//            ArticleToPDFConverter converter = new ArticleToPDFConverter(pingFangPath, pingFangPath);
            // (微软) (新) 宋体
            String simSunPath = "/Users/zen/develop/IdeaProjects/JavaLearn/practice/src/main/java/p21/SimSun.ttf";
            ArticleToPDFConverter converter = new ArticleToPDFConverter(simSunPath, simSunPath);

            // 示例文章标题和内容
            String articleTitle = "人工智能的现状与未来发展";
            String articleContent = "我国高铁经过数十年的沧桑发展，现在早已成为世界上的一张靓丽中国名片。但近日，有网友发文质疑二等座和无座票同价的行为是否真的合理，虽然12306工作人员已经给出具体回应，但仍引发热议。由此可见，重要的并非是理由能否被理解，而是在大众理解之上有没有主动解决公共服务问题。\n" +
                    "   高铁部门在票价决策中确实蕴含着复杂的现实考量。一般购买无座票的往往是紧急或必须出行的人群，例如春运和大型节假日，或遇其他紧急情况出行的人。这个时候人们多半更在意行程问题而非票价问题。无座票本身就是为了满足特定人群的出行需求才设立的，再加上车厢、线路都一样，乘客享受到了同样的车辆运行、线路维护等基础服务，按全程成本均摊费用也无可厚非。这同时还避免了因定价不同而导致的日常期间因票价不同而管理混乱的问题。\n" +
                    "      回应公众不如理解公众。选择无座也不一定是乘客个人原因，还存在高铁在高峰期承载力不足的情况。明明一样的价格却享受不到同样的服务，使得很多人心里不平衡；一路上遇到空座位才敢坐一小会儿，遇到原坐乘客出现，还得起身连连抱歉，也让很多人心生委屈。这种不平衡和委屈说到底并不是价格问题，而是尊严感和公平感的缺失。对于铁路企业而言，最重要的，是从多元需求中找到最大公约数，提供更人性化的服务，真正理解公众，才能逐步根治问题。\n" +
                    "        更何况，高铁票价之困并非无路可走。其实，高铁部门一旦理解了公众内心不公平感的来源，相应的政策便会随之而来。例如，可以设置分时间段阶梯票价供不同需求的人们选择；或在车厢设立固定的爱心无座票座位，为老人、孕妇等特殊人群提供便利。这样的措施不仅缓解高铁高峰期压力，更体现人文关怀。\n" +
                    "       服务的核心在于以人为本。这不是抽象的概念或者漂亮的口号，而是藏在每一次和公众的接触、政策的制定和服务细节中。唯有将这种关怀深深融入高铁的血脉，才能真正从根源解决问题，让高铁的发展与公众的满意同行。";

            // 转换为PDF
            String outputFile = "/Users/zen/develop/front/article.pdf";
            converter.convertToPDF(articleTitle, articleContent, outputFile);
        } catch (IOException e) {
            System.err.println("生成PDF时出错: " + e.getMessage());
            e.printStackTrace();
        }
    }

}

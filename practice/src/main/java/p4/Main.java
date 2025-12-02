//package p4;
//
//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.JAXBException;
//import javax.xml.bind.Marshaller;
//import java.io.File;
//
//public class Main {
//    public static void main(String[] args) {
//        Person person = new Person("小小", "11");
//        File file = new File("D:\\TEMP\\person.xml");
//        try {
//            //根据Person类生成上下文对象
//            JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
//            //从上下文对象中获取Marshaller对象，用做将bean编组（转换）为xml
//            Marshaller marshaller = jaxbContext.createMarshaller();
//            //以下是对生成xml的一些配置
//            //格式化输出，即标签自动换行，否则就是一行输出
//            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//            //设置编码
//            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
//            //是否省略xml头信息，默认不省略
//            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);
//            //编组
//            marshaller.marshal(person, file);
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
//
//    }
//}

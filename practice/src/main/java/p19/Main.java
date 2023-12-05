package p19;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author zhengqiang
 * @Date 2023/11/10
 */
public class Main {
    public static void main(String[] args) {
        List<CPPatOrderVO> selectCPOrderVOs = new ArrayList<>();
        Map<Double, List<CPPatOrderVO>> collect = selectCPOrderVOs.stream().filter(p -> p != null && p.getOrderId() != null && p.getGroupNo() != null).collect(Collectors.groupingBy(CPPatOrderVO::getGroupNo));
        List<List<CPPatOrderVO>> cPPatOrderVOGroupList = new ArrayList<>();
        for (Map.Entry<Double, List<CPPatOrderVO>> impOrderVOEntry : collect.entrySet()) {
            cPPatOrderVOGroupList.add(impOrderVOEntry.getValue());
        }

        HashMap<Long, ImpOrderVO> orderMap = new HashMap<>();
        Map<Double, List<ImpOrderVO>> collect1 = orderMap.entrySet().stream().map(p -> p.getValue()).collect(Collectors.groupingBy(ImpOrderVO::getOrderGroupNo));
        List<List<ImpOrderVO>> impOrderVOGroupList = new ArrayList<>();
        for (Map.Entry<Double, List<ImpOrderVO>> impOrderVOEntry : collect1.entrySet()) {
            impOrderVOGroupList.add(impOrderVOEntry.getValue());
        }

        List<List<ImpOrderVO>> matchingData = impOrderVOGroupList.stream()
                .filter(impOrderList -> cPPatOrderVOGroupList.stream()
                        .anyMatch(cPPatOrderList -> hasMatchingOrder(cPPatOrderList, impOrderList)))
                .collect(Collectors.toList());

        matchingData.forEach(impOrderList -> impOrderList.stream().forEach(impOrder -> impOrder.setExternalMedicine("0")));
    }
    private static boolean hasMatchingOrder(List<CPPatOrderVO> cppOrderList, List<ImpOrderVO> impOrderList) {
        return cppOrderList.size() == impOrderList.size() && cppOrderList.stream()
                .allMatch(cppOrder -> impOrderList.stream()
                        .anyMatch(impOrder ->
                                cppOrder.getOrderServiceCode().equals(impOrder.getOrderServiceCode())
                                        && cppOrder.getOrderId().equals(impOrder.getId())
                        )
                );
    }

    private static boolean areOrdersMatching(CPPatOrderVO cppOrder, ImpOrderVO impOrder) {
        return cppOrder.getOrderServiceCode().equals(impOrder.getOrderServiceCode())
                && cppOrder.getOrderId().equals(impOrder.getId());
    }
}

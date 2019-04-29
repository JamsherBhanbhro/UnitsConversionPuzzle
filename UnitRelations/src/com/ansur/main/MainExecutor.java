package com.ansur.main;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainExecutor {
	
    public static void main(String args[]) {
        execute();
        return;
    }

    public static void execute() {
    	Scanner sc = new Scanner(System.in);
    	try {
        while(true){
            List<Unit> unitList = null;
                int num = sc.nextInt();
                if (num == 0) {
                    break;
                }
                if (num >= 2 && num <= 10) {
                    sc.nextLine();
                    String units = sc.nextLine();
                    if (null != units && units.matches("[a-zA-Z][a-zA-Z ]+")) {
                        String[] unitNames = units.split(" ");
                        unitList = new ArrayList<Unit>();
                        for (String unit : unitNames) {
                            if (unit.length() <= 5)
                                unitList.add(new Unit(unit));
                        }
                        for (int i = 1; i < unitList.size(); i++) {
                            String cFact = sc.nextLine();
                            String[] cFactor = cFact.split(" ");
                            if (null != cFactor && cFactor.length == 4 && units.contains(cFactor[0])
                                    && cFactor[1].equals("=") && Integer.parseInt(cFactor[2]) > 0
                                    && units.contains(cFactor[3])) {
                                for (Unit unit : unitList) {
                                    if (unit.getName().equals(cFactor[0])) {
                                        unit.getcFactMap().put(cFactor[3], Integer.parseInt(cFactor[2]));
                                        break;
                                    }
                                }
                            }
                        }
                        for (int i = 0; i < num; i++) {
                            mapByMult(unitList);
                        }
                        if (checkPrint(unitList, num))
                            continue;

                        for (int i = 0; i < num; i++) {
                            mapByDiv(unitList);
                        }
                        if (checkPrint(unitList, num))
                            continue;
                        mapByMult(unitList);
                        checkPrint(unitList, num);
                    }
                }
            
        }
    	} catch (Exception e) {
            e.printStackTrace();
        } finally {
			sc.close();
		}



    }

    public static void mapByDiv(List<Unit> unitList) {
        for (Unit unit : unitList) {
            if (null != unit.getcFactMap()) {
                for (String key : unit.getcFactMap().keySet()) {
                    for (Unit lunit : unitList) {
                        if (lunit.getcFactMap().containsKey(key) && !lunit.getName().equals(unit.getName())) {
                            int factor = unit.getcFactMap().get(key);
                            for (String lUnitkey : lunit.getcFactMap().keySet()) {
                                if (lunit.getcFactMap().get(lUnitkey) < factor
                                        && !unit.getcFactMap().containsKey(lunit.getName()))
                                    unit.getcFactMap().put(lunit.getName(), factor / lunit.getcFactMap().get(lUnitkey));
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public static void mapByMult(List<Unit> unitList) {
        for (Unit unit : unitList) {
            if (null != unit.getcFactMap()) {
                for (String key : unit.getcFactMap().keySet()) {
                    for (Unit lunit : unitList) {
                        if (lunit.getName().equals(key)) {
                            int factor = unit.getcFactMap().get(key);
                            for (String lUnitkey : lunit.getcFactMap().keySet()) {
                                if (!unit.getcFactMap().containsKey(lUnitkey))
                                    unit.getcFactMap().put(lUnitkey, lunit.getcFactMap().get(lUnitkey) * factor);
                            }
                        }
                    }
                }
            }
        }
    }

    public static void sortPrint(Unit unit) {
        Map<String, Integer> sorted = unit.getcFactMap().entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
        System.out.println();
        System.out.print(1 + unit.getName());
        for (String key : sorted.keySet()) {
          System.out.print(" = " + unit.getcFactMap().get(key) + key);
          
      }
    }

    public static boolean checkPrint(List<Unit> unitList, int num) {
        for (Unit unit : unitList) {
            if (unit.getcFactMap().size() == num - 1) {
                sortPrint(unit);
                return true;
            }
        }
        return false;
    }
}

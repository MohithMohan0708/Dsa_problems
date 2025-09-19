class Spreadsheet {
    private int[][] sheet;

    public Spreadsheet(int rows) {
        sheet = new int[rows][26];
    }

    public void setCell(String cell, int value) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;
        if (row >= 0 && row < sheet.length && col >= 0 && col < 26) {
            sheet[row][col] = value;
        }
    }

    public void resetCell(String cell) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;
        if (row >= 0 && row < sheet.length && col >= 0 && col < 26) {
            sheet[row][col] = 0;
        }
    }

    public int getValue(String formula) {
        if (formula.startsWith("=")) {
            formula = formula.substring(1);
        }

        String[] arr = formula.split("\\+");
        String first = arr[0].trim();
        String second = arr[1].trim();

        int ans = 0;

        if (!isNumber(first) && !isNumber(second)) {
            ans += safeGet(first) + safeGet(second);
        } else if (isNumber(first) && isNumber(second)) {
            ans += safeParse(first) + safeParse(second);
        } else if (!isNumber(first) && isNumber(second)) {
            ans += safeGet(first) + safeParse(second);
        } else {
            ans += safeParse(first) + safeGet(second);
        }

        return ans;
    }

    private boolean isNumber(String s) {
        return Character.isDigit(s.charAt(0)) || (s.charAt(0) == '-' && s.length() > 1);
    }

    private int safeGet(String cell) {
        try {
            int col = cell.charAt(0) - 'A';
            int row = Integer.parseInt(cell.substring(1)) - 1;
            if (row >= 0 && row < sheet.length && col >= 0 && col < 26) {
                return sheet[row][col];
            }
        } catch (Exception e) {
            return 0;
        }
        return 0;
    }

    private int safeParse(String s) {
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            return 0;
        }
    }
}

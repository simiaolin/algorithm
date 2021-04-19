package thread;

public class RaceCondition implements Runnable {
    /**
     * 计算类型，1表示减法，其他的表示加法
     */
    private int type;

    public RaceCondition(int type) {
        this.type = type;
    }

    public void run() {
        if (type == 1)
            for (int i = 0; i < 10000; i++)
                Test.num--;
        else
            for (int i = 0; i < 10000; i++)
                Test.num++;
    }

}


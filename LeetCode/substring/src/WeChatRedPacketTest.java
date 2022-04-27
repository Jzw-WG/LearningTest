import java.lang.reflect.Member;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class WeChatRedPacketTest {
    /**
     * 规则：n个人发，抢红包，定尾数a，有人抢到尾数为a则踩雷，给发红包的人1.2倍本金
     * 庄家有特权，踩雷只需要付0.5倍本金
     */
    private int member; //参与者人数
    private int vipIndex;
    private float[] members; //全部参与者余额
    
    public WeChatRedPacketTest(int member, int vipIndex) {
        this.member = member;
        this.vipIndex = vipIndex;
        this.members = new float[member];
        for (int i = 0; i < members.length; i++) {
            members[i] = 0;
        }
    }

    /**
     * 
     * @param remain 红包剩余数量（总量）
     * @param num 红包分成几分
     * @param redPackets 结果列表
     */
    public void getMoney(float remain, int num, float[] redPackets) {
        float money;
        for (int i = 0; i < num; i++) {
            if (i == num - 1) {
                money = remain;
            } else {
                money = (float) (0.01 + Math.random() * (remain / (num - i) * 2));
            }
            DecimalFormat df = new DecimalFormat("0.00");
            String str = df.format(money);
            money = Float.parseFloat(str);
            redPackets[i] = money;
            remain = remain - money;
            // System.out.println(money);
        }
    }

    /**
     * 
     * @param leaderNo 发红包者id
     * @param redPacketRMB 红包大小
     * @param num 可抢到红包的人数
     */
    public void startAGame(int leaderNo, float redPacketRMB, int num, String tailNum) {
        if (num > member) {
            System.out.println("num error");
            return;
        }
        members[leaderNo] = members[leaderNo] - redPacketRMB; //发红包者余额扣除红包大小
        int[] randomList = new int[num];
        genetateRandomList(member, leaderNo, randomList);
        float[] results = new float[num];
        getMoney(redPacketRMB, num, results);
        for (int i = 0; i < randomList.length; i++) {
            int id = randomList[i];
            float money = results[i];
            members[id] += money; //抢到的红包加入余额
            DecimalFormat df = new DecimalFormat("0.00");
            String str = df.format(money);
            String tail = str.substring(str.length() - 1, str.length());
            float loseRate = id == vipIndex?0.5f:1.2f;
            if (tail.equals(tailNum)) {
                members[id] -= loseRate * redPacketRMB;
                members[leaderNo] += loseRate * redPacketRMB;
            }
        }
    }

    //随机抢到红包的人的id列表,排除发红包者
    private void genetateRandomList(int nums, int exception, int[] randomList)
    {
        ArrayList<Integer> all = new ArrayList<>();
        for (int i = 0; i < member; i++) {
            all.add(i);
        }
        all.remove(new Integer(exception));
        
        for (int i = 0; i < randomList.length; i++) {
            Random random = new Random();
            Math.random();
            //在数组大小之间产生一个随机数 j
            int j = random.nextInt(all.size());
            randomList[i] = all.get(j);
            //把已取到的数据移除,避免下次再次取到出现重复
            all.remove(j);
        }
        
    }

    public static void main(String[] args) {
        int memberNum = 200;
        WeChatRedPacketTest wr = new WeChatRedPacketTest(memberNum, 0);
        // float[] results = new float[memberNum];
        for (int i = 0; i < 200; i++) {
            Random rand = new Random();
            String randomTailNum = Integer.toString(rand.nextInt(10));
            int randomLeader = rand.nextInt(wr.member);
            wr.startAGame(i % memberNum, 100, 5, randomTailNum);//轮流发红包
        }

        for (int i = 0; i < wr.members.length; i++) {
            System.out.println(wr.members[i]);
        }
        
        // wr.getMoney(100, memberNum, results);
    }
}
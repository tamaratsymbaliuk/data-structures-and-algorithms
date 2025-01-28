public class SellBuyDays {

        public int maxProfit(int[] prices) {

            int days = prices.length;
            int profit = 0;
            int buy_day = 0;
            int sell_day = 0;

            while (buy_day < days && sell_day < days) {
                while (buy_day < days - 1 && prices[buy_day + 1] <= prices[buy_day]) {
                    buy_day++; // find the next valley of prices
                }

                sell_day = buy_day;
                while (sell_day < days - 1 && prices[sell_day + 1] >= prices[sell_day]) {
                    sell_day++; // find the next peak of prices
                }

                // buy at valley, sell at peak
                profit += prices[sell_day] - prices[buy_day];
                buy_day = sell_day + 1;
            }
            return profit;
        }

        public static void main(String[] args) {
            int[] days = {7,1,5,3,6,4};
            SellBuyDays test = new SellBuyDays();
            int result = test.maxProfit(days);
            System.out.println(result);
        }
    }


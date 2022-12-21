import java.net.*;

public class Crawler {
    private URLPool pool;

    public int threads = 8;

    public Crawler(String hostUrl, int depth) throws MalformedURLException {
        pool = new URLPool(depth);

        URL rootURL = new URL(hostUrl);
        pool.add(new URLDepthPair(rootURL, 0));
    }

    // Запуск сканера
    public void crawl() {
        // Потоки
        for (int i = 0; i < threads; i++) {
            CrawlerTask crawler = new CrawlerTask(pool);
            Thread thread = new Thread(crawler);
            thread.start();
        }
        // Проверка потоков, если все ждут, то работа завершена
        while (pool.getWaitCount() != threads) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println();
        pool.printURLs();
    }

    public static void main(String[] args) {
        args = new String[] {"http://www.europe-fluxdata.eu/home/sites-list", "2"};
        if (args.length != 2) {
            System.err.println("Аргументы: <URL> <Depth>");
            System.exit(1);
        }
        try {
            Crawler crawler = new Crawler(args[0], Integer.parseInt(args[1]));
            crawler.crawl();
        } catch (MalformedURLException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        System.exit(0);
    }
}
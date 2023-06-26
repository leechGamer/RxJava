class Main {
	public static void main(String[] args) {
		PublishProcessor<Integer> processor = PublishProcessor.create();
		processor.subscribe(data -> System.out.println("구독자1:" + data));
		processor.onNext(1);
		processor.onNext(3);

		processor.subscribe(data -> System.out.println("구독자2:" + data));
		processor.onNext(5);
		processor.onNext(7);

		processor.onComplete();

		/**
		 * Hot publisher
		 * 구독자1:1
		 * 구독자1:3
		 * 구독자1:5
		 * 구독자2:5
		 * 구독자1:7
		 * 구독자2:7
		 */
	}
}

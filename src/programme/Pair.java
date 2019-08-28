package programme;
public class Pair<T>{

		T first=null;
		T second=null;
		public Pair() {
			// TODO Auto-generated constructor stub
		}
		public Pair(T first,T second) {
			// TODO Auto-generated constructor stub
			this.first=first;
			this.second=second;
		}

		public void setFirst(T f) {
			this.first=f;
		}
		
		public void setSecond(T f) {
			this.second=f;
		}
		
		public T getFirst() {
			return first;
		}
		public T getSecond() {
			return second;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "first: "+first+" second: "+second;
		}
	}

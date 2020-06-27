package chapter2;

import java.util.ArrayList;
import java.util.List;

public class Network {
    public class Member {
        private String name;

        public Member(String name) {
            this.name = name;
        }

        public void leave() {
            removeMember(this);
        }

        public boolean belongsTo(Network n) {
            return Network.this == n;
        }
    }

    List<Member> members = new ArrayList<>();

    public Member join(String name) {
        Member newMember = new Member(name);
        members.add(newMember);
        return newMember;
    }

    public void removeMember(Member m) {
        members.remove(m);
    }

    public int numOfMembers() {
        return this.members.size();
    }

    public static void main(String[] args) {
        Network net = new Network();
        Network net1 = new Network();
        Member fred = net1.new Member("Fred");
        System.out.printf("Fred belongs to net = %s\n", fred.belongsTo(net));
        System.out.printf("Fred belongs to net1 = %s\n", fred.belongsTo(net1));
    }
}

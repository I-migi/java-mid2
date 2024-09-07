package collection.set.member;

import java.util.Objects;

public class MemberOnlyHash {

    private String id;

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public String getId() {
        return id;
    }

    public MemberOnlyHash(String id) {
        this.id = id;
    }
}

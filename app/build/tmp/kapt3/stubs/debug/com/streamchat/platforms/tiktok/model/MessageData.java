package com.streamchat.platforms.tiktok.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\bH\u00c6\u0003\u00a2\u0006\u0002\u0010\u000fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\bH\u00c6\u0003\u00a2\u0006\u0002\u0010\u000fJH\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u00c6\u0001\u00a2\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001e\u001a\u00020\bH\u00d6\u0001J\t\u0010\u001f\u001a\u00020\u0005H\u00d6\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\t\u001a\u0004\u0018\u00010\b\u00a2\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006 "}, d2 = {"Lcom/streamchat/platforms/tiktok/model/MessageData;", "", "user", "Lcom/streamchat/platforms/tiktok/model/TikTokUser;", "content", "", "giftName", "giftValue", "", "likeCount", "(Lcom/streamchat/platforms/tiktok/model/TikTokUser;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getContent", "()Ljava/lang/String;", "getGiftName", "getGiftValue", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLikeCount", "getUser", "()Lcom/streamchat/platforms/tiktok/model/TikTokUser;", "component1", "component2", "component3", "component4", "component5", "copy", "(Lcom/streamchat/platforms/tiktok/model/TikTokUser;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/streamchat/platforms/tiktok/model/MessageData;", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class MessageData {
    @org.jetbrains.annotations.NotNull()
    private final com.streamchat.platforms.tiktok.model.TikTokUser user = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String content = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String giftName = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer giftValue = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer likeCount = null;
    
    public MessageData(@org.jetbrains.annotations.NotNull()
    com.streamchat.platforms.tiktok.model.TikTokUser user, @org.jetbrains.annotations.Nullable()
    java.lang.String content, @org.jetbrains.annotations.Nullable()
    java.lang.String giftName, @org.jetbrains.annotations.Nullable()
    java.lang.Integer giftValue, @org.jetbrains.annotations.Nullable()
    java.lang.Integer likeCount) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.streamchat.platforms.tiktok.model.TikTokUser getUser() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getContent() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getGiftName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getGiftValue() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getLikeCount() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.streamchat.platforms.tiktok.model.TikTokUser component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.streamchat.platforms.tiktok.model.MessageData copy(@org.jetbrains.annotations.NotNull()
    com.streamchat.platforms.tiktok.model.TikTokUser user, @org.jetbrains.annotations.Nullable()
    java.lang.String content, @org.jetbrains.annotations.Nullable()
    java.lang.String giftName, @org.jetbrains.annotations.Nullable()
    java.lang.Integer giftValue, @org.jetbrains.annotations.Nullable()
    java.lang.Integer likeCount) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}
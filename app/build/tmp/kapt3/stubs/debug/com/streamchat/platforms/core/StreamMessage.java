package com.streamchat.platforms.core;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b#\b\u0086\b\u0018\u00002\u00020\u0001Bi\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0002\u0010\u0014J\t\u0010&\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010\'\u001a\u0004\u0018\u00010\u0013H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001cJ\t\u0010(\u001a\u00020\u0003H\u00c6\u0003J\t\u0010)\u001a\u00020\u0003H\u00c6\u0003J\t\u0010*\u001a\u00020\u0007H\u00c6\u0003J\t\u0010+\u001a\u00020\tH\u00c6\u0003J\t\u0010,\u001a\u00020\u000bH\u00c6\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010.\u001a\u00020\u000eH\u00c6\u0003J\u0011\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u00c6\u0003J~\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u00c6\u0001\u00a2\u0006\u0002\u00101J\u0013\u00102\u001a\u00020\u000e2\b\u00103\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00104\u001a\u00020\u0013H\u00d6\u0001J\t\u00105\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u001aR\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%\u00a8\u00066"}, d2 = {"Lcom/streamchat/platforms/core/StreamMessage;", "", "id", "", "text", "author", "timestamp", "", "platform", "Lcom/streamchat/platforms/core/PlatformType;", "type", "Lcom/streamchat/platforms/core/MessageType;", "originalText", "isTranslated", "", "gifts", "", "Lcom/streamchat/platforms/core/Gift;", "likes", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLcom/streamchat/platforms/core/PlatformType;Lcom/streamchat/platforms/core/MessageType;Ljava/lang/String;ZLjava/util/List;Ljava/lang/Integer;)V", "getAuthor", "()Ljava/lang/String;", "getGifts", "()Ljava/util/List;", "getId", "()Z", "getLikes", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getOriginalText", "getPlatform", "()Lcom/streamchat/platforms/core/PlatformType;", "getText", "getTimestamp", "()J", "getType", "()Lcom/streamchat/platforms/core/MessageType;", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLcom/streamchat/platforms/core/PlatformType;Lcom/streamchat/platforms/core/MessageType;Ljava/lang/String;ZLjava/util/List;Ljava/lang/Integer;)Lcom/streamchat/platforms/core/StreamMessage;", "equals", "other", "hashCode", "toString", "app_debug"})
public final class StreamMessage {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String id = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String text = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String author = null;
    private final long timestamp = 0L;
    @org.jetbrains.annotations.NotNull()
    private final com.streamchat.platforms.core.PlatformType platform = null;
    @org.jetbrains.annotations.NotNull()
    private final com.streamchat.platforms.core.MessageType type = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String originalText = null;
    private final boolean isTranslated = false;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<com.streamchat.platforms.core.Gift> gifts = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer likes = null;
    
    public StreamMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String text, @org.jetbrains.annotations.NotNull()
    java.lang.String author, long timestamp, @org.jetbrains.annotations.NotNull()
    com.streamchat.platforms.core.PlatformType platform, @org.jetbrains.annotations.NotNull()
    com.streamchat.platforms.core.MessageType type, @org.jetbrains.annotations.Nullable()
    java.lang.String originalText, boolean isTranslated, @org.jetbrains.annotations.Nullable()
    java.util.List<com.streamchat.platforms.core.Gift> gifts, @org.jetbrains.annotations.Nullable()
    java.lang.Integer likes) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getText() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAuthor() {
        return null;
    }
    
    public final long getTimestamp() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.streamchat.platforms.core.PlatformType getPlatform() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.streamchat.platforms.core.MessageType getType() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getOriginalText() {
        return null;
    }
    
    public final boolean isTranslated() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.streamchat.platforms.core.Gift> getGifts() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getLikes() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    public final long component4() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.streamchat.platforms.core.PlatformType component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.streamchat.platforms.core.MessageType component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component7() {
        return null;
    }
    
    public final boolean component8() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.streamchat.platforms.core.Gift> component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.streamchat.platforms.core.StreamMessage copy(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String text, @org.jetbrains.annotations.NotNull()
    java.lang.String author, long timestamp, @org.jetbrains.annotations.NotNull()
    com.streamchat.platforms.core.PlatformType platform, @org.jetbrains.annotations.NotNull()
    com.streamchat.platforms.core.MessageType type, @org.jetbrains.annotations.Nullable()
    java.lang.String originalText, boolean isTranslated, @org.jetbrains.annotations.Nullable()
    java.util.List<com.streamchat.platforms.core.Gift> gifts, @org.jetbrains.annotations.Nullable()
    java.lang.Integer likes) {
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
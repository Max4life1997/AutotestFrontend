package configs;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public interface Config {

    static @Nullable Config getInstance(@NonNull String env) {
        switch (env) {
            case "local":
                return LocalConfig.getInstance();
            default:
                throw new RuntimeException(String.format("Среда выполнениния %s не найдена", env));
        }
    }

    @Nullable String getProperty(@NonNull String propertyName);
}

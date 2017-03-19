package co.original.codigo.ems_tracker_admin.helpers.EventBus;

public interface EventBus {

    void register(Object subscriber);

    void unregister(Object subscriber);

    void post(Object event);

}

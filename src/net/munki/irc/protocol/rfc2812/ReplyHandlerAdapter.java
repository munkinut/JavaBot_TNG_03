/*
 * ReplyHandlerAdapter.java
 *
 * Created on 24 July 2002, 09:09
 */

package net.munki.irc.protocol.rfc2812;

public abstract class ReplyHandlerAdapter implements ReplyHandlerInterface {

    /** Creates new ReplyHandlerAdapter */
    public ReplyHandlerAdapter() {
    }

    public void ERR_NICKCOLLISION(String reply) {
    }
    
    public void ERR_NOSUCHNICK(String reply) {
    }
    
    public void RPL_WHOISOPERATOR(String reply) {
    }
    
    public void RPL_ENDOFBANLIST(String reply) {
    }
    
    public void RPL_MYPORTIS(String reply) {
    }
    
    public void RPL_STATSDLINE(String reply) {
    }
    
    public void RPL_KILLDONE(String reply) {
    }
    
    public void ERR_UNAVAILRESOURCE(String reply) {
    }
    
    public void RPL_LUSERCHANNELS(String reply) {
    }
    
    public void RPL_STATSYLINE(String reply) {
    }
    
    public void RPL_NOWAWAY(String reply) {
    }
    
    public void ERR_NEEDMOREPARAMS(String reply) {
    }
    
    public void ERR_NOCHANMODES(String reply) {
    }
    
    public void ERR_WILDTOPLEVEL(String reply) {
    }
    
    public void ERR_TOOMANYTARGETS(String reply) {
    }
    
    public void RPL_STATSLINKINFO(String reply) {
    }
    
    public void ERR_INVITEONLYCHAN(String reply) {
    }
    
    public void RPL_LIST(String reply) {
    }
    
    public void RPL_STATSOLINE(String reply) {
    }
    
    public void RPL_CLOSEEND(String reply) {
    }
    
    public void RPL_REHASHING(String reply) {
    }
    
    public void RPL_ISON(String reply) {
    }
    
    public void RPL_NOTOPIC(String reply) {
    }
    
    public void ERR_NOORIGIN(String reply) {
    }
    
    public void RPL_ENDOFINFO(String reply) {
    }
    
    public void RPL_BANLIST(String reply) {
    }
    
    public void RPL_WHOISIDLE(String reply) {
    }
    
    public void RPL_STATSPING(String reply) {
    }
    
    public void RPL_STATSVLINE(String reply) {
    }
    
    public void ERR_NONICKNAMEGIVEN(String reply) {
    }
    
    public void RPL_INFO(String reply) {
    }
    
    public void RPL_WELCOME() {
    }
    
    public void RPL_ENDOFUSERS(String reply) {
    }
    
    public void RPL_ENDOFSTATS(String reply) {
    }
    
    public void ERR_PASSWDMISMATCH(String reply) {
    }
    
    public void RPL_STATSUPTIME(String reply) {
    }
    
    public void RPL_INVITING(String reply) {
    }
    
    public void ERR_NOSUCHCHANNEL(String reply) {
    }
    
    public void ERR_TOOMANYCHANNELS(String reply) {
    }
    
    public void ERR_NOLOGIN(String reply) {
    }
    
    public void ERR_RESTRICTED(String reply) {
    }
    
    public void ERR_BANNEDFROMCHAN(String reply) {
    }
    
    public void ERR_UNKNOWNMODE(String reply) {
    }
    
    public void RPL_USERSSTART(String reply) {
    }
    
    public void ERR_NOTREGISTERED(String reply) {
    }
    
    public void ERR_FILEERROR(String reply) {
    }
    
    public void RPL_SERVLISTEND(String reply) {
    }
    
    public void RPL_ENDOFMOTD(String reply) {
    }
    
    public void ERR_USERNOTINCHANNEL(String reply) {
    }
    
    public void RPL_SUMMONING(String reply) {
    }
    
    public void RPL_ENDOFSERVICES(String reply) {
    }
    
    public void ERR_WASNOSUCHNICK(String reply) {
    }
    
    public void RPL_USERHOST(String reply) {
    }
    
    public void ERR_CHANOPRIVSNEEDED(String reply) {
    }
    
    public void RPL_YOURHOST(String reply) {
    }
    
    public void ERR_CANTKILLSERVER(String reply) {
    }
    
    public void ERR_KEYSET(String reply) {
    }
    
    public void ERR_SUMMONDISABLED(String reply) {
    }
    
    public void ERR_UNIQOPPRIVSNEEDED(String reply) {
    }
    
    public void ERR_ERRONEUSNICKNAME(String reply) {
    }
    
    public void RPL_NAMREPLY(String reply) {
    }
    
    public void RPL_NOUSERS(String reply) {
    }
    
    public void RPL_UMODEIS(String reply) {
    }
    
    public void RPL_WHOISCHANOP(String reply) {
    }
    
    public void RPL_LUSEROP(String reply) {
    }
    
    public void RPL_SERVICE(String reply) {
    }
    
    public void ERR_UMODEUNKNOWNFLAG(String reply) {
    }
    
    public void RPL_LINKS(String reply) {
    }
    
    public void ERR_NOOPERHOST(String reply) {
    }
    
    public void RPL_STATSQLINE(String reply) {
    }
    
    public void RPL_TRACEEND(String reply) {
    }
    
    public void ERR_NOTOPLEVEL(String reply) {
    }
    
    public void RPL_LUSERCLIENT(String reply) {
    }
    
    public void RPL_LUSERUNKNOWN(String reply) {
    }
    
    public void RPL_ADMINLOC2(String reply) {
    }
    
    public void RPL_STATSCLINE(String reply) {
    }
    
    public void RPL_ENDOFINVITELIST(String reply) {
    }
    
    public void RPL_ENDOFLINKS(String reply) {
    }
    
    public void ERR_NOADMININFO(String reply) {
    }
    
    public void RPL_YOURESERVICE(String reply) {
    }
    
    public void RPL_ENDOFWHO(String reply) {
    }
    
    public void ERR_NORECIPIENT(String reply) {
    }
    
    public void RPL_ADMINLOC1(String reply) {
    }
    
    public void ERR_BADCHANNELKEY(String reply) {
    }
    
    public void ERR_BADMASK(String reply) {
    }
    
    public void RPL_ENDOFWHOIS(String reply) {
    }
    
    public void RPL_SERVICEINFO(String reply) {
    }
    
    public void RPL_TRACELINK(String reply) {
    }
    
    public void ERR_NOSUCHSERVICE(String reply) {
    }
    
    public void RPL_LISTEND(String reply) {
    }
    
    public void RPL_INFOSTART(String reply) {
    }
    
    public void RPL_STATSNLINE(String reply) {
    }
    
    public void RPL_ENDOFEXCEPTLIST(String reply) {
    }
    
    public void RPL_STATSKLINE(String reply) {
    }
    
    public void ERR_BANLISTFULL(String reply) {
    }
    
    public void RPL_MOTDSTART(String reply) {
    }
    
    public void RPL_TRACECONNECTING(String reply) {
    }
    
    public void RPL_MYINFO(String reply) {
    }
    
    public void ERR_USERSDISABLED(String reply) {
    }
    
    public void RPL_ENDOFWHOWAS(String reply) {
    }
    
    public void ERR_YOUREBANNEDCREEP(String reply) {
    }
    
    public void RPL_MOTD(String reply) {
    }
    
    public void RPL_STATSHLINE(String reply) {
    }
    
    public void RPL_CLOSING(String reply) {
    }
    
    public void ERR_NICKNAMEINUSE() {
    }
    
    public void RPL_TOPIC(String reply) {
    }
    
    public void ERR_ALREADYREGISTERED(String reply) {
    }
    
    public void RPL_STATSSLINE(String reply) {
    }
    
    public void RPL_STATSLLINE(String reply) {
    }
    
    public void ERR_NOTEXTTOSEND(String reply) {
    }
    
    public void RPL_TRACEOPERATOR(String reply) {
    }
    
    public void ERR_BADCHANMASK(String reply) {
    }
    
    public void RPL_CHANNELMODEIS(String reply) {
    }
    
    public void RPL_INVITELIST(String reply) {
    }
    
    public void RPL_UNIQOPIS(String reply) {
    }
    
    public void ERR_CHANNELISFULL(String reply) {
    }
    
    public void ERR_CANNOTSENDTOCHAN(String reply) {
    }
    
    public void RPL_STATSBLINE(String reply) {
    }
    
    public void RPL_WHOISCHANNELS(String reply) {
    }
    
    public void RPL_STATSCOMMANDS(String reply) {
    }
    
    public void RPL_NONE(String reply) {
    }
    
    public void ERR_NOPRIVILEGES(String reply) {
    }
    
    public void RPL_BOUNCE(String reply) {
    }
    
    public void ERR_YOUWILLBEBANNED(String reply) {
    }
    
    public void RPL_ENDOFNAMES(String reply) {
    }
    
    public void RPL_TRACELOG(String reply) {
    }
    
    public void ERR_NOTONCHANNEL(String reply) {
    }
    
    public void ERR_NOMOTD(String reply) {
    }
    
    public void RPL_TRACESERVICE(String reply) {
    }
    
    public void ERR_NOSUCHSERVER(String reply) {
    }
    
    public void ERR_USERONCHANNEL(String reply) {
    }
    
    public void RPL_TRACECLASS(String reply) {
    }
    
    public void ERR_UNKNOWNCOMMAND(String reply) {
    }
    
    public void RPL_TIME(String reply) {
    }
    
    public void RPL_TRACEHANDSHAKE(String reply) {
    }
    
    public void RPL_TRACESERVER(String reply) {
    }
    
    public void RPL_STATSILINE(String reply) {
    }
    
    public void RPL_SERVLIST(String reply) {
    }
    
    public void RPL_TRACENEWTYPE(String reply) {
    }
    
    public void RPL_WHOWASUSER(String reply) {
    }
    
    public void RPL_WHOREPLY(String reply) {
    }
    
    public void ERR_NOPERMFORHOST(String reply) {
    }
    
    public void RPL_VERSION(String reply) {
    }
    
    public void RPL_USERS(String reply) {
    }
    
    public void RPL_LUSERME(String reply) {
    }
    
    public void RPL_UNAWAY(String reply) {
    }
    
    public void RPL_TRACERECONNECT(String reply) {
    }
    
    public void RPL_TRACEUNKNOWN(String reply) {
    }
    
    public void RPL_LISTSTART(String reply) {
    }
    
    public void ERR_USERSDONTMATCH(String reply) {
    }
    
    public void RPL_EXCEPTLIST(String reply) {
    }
    
    public void RPL_YOUREOPER(String reply) {
    }
    
    public void RPL_TRACEUSER(String reply) {
    }
    
    public void RPL_WHOISUSER(String reply) {
    }
    
    public void RPL_WHOISSERVER(String reply) {
    }
    
    public void RPL_ADMINEMAIL(String reply) {
    }
    
    public void RPL_TRYAGAIN(String reply) {
    }
    
    public void RPL_ADMINME(String reply) {
    }
    
    public void RPL_CREATED(String reply) {
    }
    
    public void RPL_AWAY(String reply) {
    }
    
}

/*
 * ReplyHandlerInterface.java
 *
 * Created on 24 July 2002, 08:53
 */

package net.munki.irc.protocol.rfc2812;

public interface ReplyHandlerInterface {

    // 5.1 Command responses
    
    void RPL_WELCOME(String reply) throws ReplyHandlerException;    //001";
    void RPL_YOURHOST(String reply) throws ReplyHandlerException;    //002";
    void RPL_CREATED(String reply) throws ReplyHandlerException;    //003";
    void RPL_MYINFO(String reply) throws ReplyHandlerException;    //004";

    void RPL_BOUNCE(String reply) throws ReplyHandlerException;    //005";

    void RPL_USERHOST(String reply) throws ReplyHandlerException;    //302";
    
    void RPL_ISON(String reply) throws ReplyHandlerException;    //303";
    
    void RPL_AWAY(String reply) throws ReplyHandlerException;    //301";
    void RPL_UNAWAY(String reply) throws ReplyHandlerException;    //305";
    void RPL_NOWAWAY(String reply) throws ReplyHandlerException;    //306";
    
    void RPL_WHOISUSER(String reply) throws ReplyHandlerException;    //311";
    void RPL_WHOISSERVER(String reply) throws ReplyHandlerException;    //312";
    void RPL_WHOISOPERATOR(String reply) throws ReplyHandlerException;    //313";
    void RPL_WHOISIDLE(String reply) throws ReplyHandlerException;    //317";
    void RPL_ENDOFWHOIS(String reply) throws ReplyHandlerException;    //318";
    void RPL_WHOISCHANNELS(String reply) throws ReplyHandlerException;    //319";

    void RPL_WHOWASUSER(String reply) throws ReplyHandlerException;    //314";
    void RPL_ENDOFWHOWAS(String reply) throws ReplyHandlerException;    //369";

    void RPL_LISTSTART(String reply) throws ReplyHandlerException;    //321";
    void RPL_LIST(String reply) throws ReplyHandlerException;    //322";
    void RPL_LISTEND(String reply) throws ReplyHandlerException;    //323";

    void RPL_UNIQOPIS(String reply) throws ReplyHandlerException;    //325";
    void RPL_CHANNELMODEIS(String reply) throws ReplyHandlerException;    //324";
    void RPL_NOTOPIC(String reply) throws ReplyHandlerException;    //331";
    void RPL_TOPIC(String reply) throws ReplyHandlerException;    //332";

    void RPL_INVITING(String reply) throws ReplyHandlerException;    //341";

    void RPL_SUMMONING(String reply) throws ReplyHandlerException;    //342";

    void RPL_INVITELIST(String reply) throws ReplyHandlerException;    //346";
    void RPL_ENDOFINVITELIST(String reply) throws ReplyHandlerException;    //347";

    void RPL_EXCEPTLIST(String reply) throws ReplyHandlerException;    //348";
    void RPL_ENDOFEXCEPTLIST(String reply) throws ReplyHandlerException;    //349";

    void RPL_VERSION(String reply) throws ReplyHandlerException;    //351";

    void RPL_WHOREPLY(String reply) throws ReplyHandlerException;    //352";
    void RPL_ENDOFWHO(String reply) throws ReplyHandlerException;    //315";

    void RPL_NAMREPLY(String reply) throws ReplyHandlerException;    //353";
    void RPL_ENDOFNAMES(String reply) throws ReplyHandlerException;    //366";

    void RPL_LINKS(String reply) throws ReplyHandlerException;    //364";
    void RPL_ENDOFLINKS(String reply) throws ReplyHandlerException;    //365";

    void RPL_BANLIST(String reply) throws ReplyHandlerException;    //367";
    void RPL_ENDOFBANLIST(String reply) throws ReplyHandlerException;    //368";

    void RPL_INFO(String reply) throws ReplyHandlerException;    //371";
    void RPL_ENDOFINFO(String reply) throws ReplyHandlerException;    //374";

    void RPL_MOTDSTART(String reply) throws ReplyHandlerException;    //375";
    void RPL_MOTD(String reply) throws ReplyHandlerException;    //372";
    void RPL_ENDOFMOTD(String reply) throws ReplyHandlerException;    //"376";

    void RPL_YOUREOPER(String reply) throws ReplyHandlerException;    //381";

    void RPL_REHASHING(String reply) throws ReplyHandlerException;    //382";

    void RPL_YOURESERVICE(String reply) throws ReplyHandlerException;    //383";

    void RPL_TIME(String reply) throws ReplyHandlerException;    //391";

    void RPL_USERSSTART(String reply) throws ReplyHandlerException;    //392";
    void RPL_USERS(String reply) throws ReplyHandlerException;    //393";
    void RPL_ENDOFUSERS(String reply) throws ReplyHandlerException;    //394";
    void RPL_NOUSERS(String reply) throws ReplyHandlerException;    //395";

    void RPL_TRACELINK(String reply) throws ReplyHandlerException;    //200";
    void RPL_TRACECONNECTING(String reply) throws ReplyHandlerException;    //201";
    void RPL_TRACEHANDSHAKE(String reply) throws ReplyHandlerException;    //202";
    void RPL_TRACEUNKNOWN(String reply) throws ReplyHandlerException;    //203";
    void RPL_TRACEOPERATOR(String reply) throws ReplyHandlerException;    //204";
    void RPL_TRACEUSER(String reply) throws ReplyHandlerException;    //205";
    void RPL_TRACESERVER(String reply) throws ReplyHandlerException;    //206";
    void RPL_TRACESERVICE(String reply) throws ReplyHandlerException;    //207";
    void RPL_TRACENEWTYPE(String reply) throws ReplyHandlerException;    //208";
    void RPL_TRACECLASS(String reply) throws ReplyHandlerException;    //209";
    void RPL_TRACERECONNECT(String reply) throws ReplyHandlerException;    //210";
    void RPL_TRACELOG(String reply) throws ReplyHandlerException;    //261";
    void RPL_TRACEEND(String reply) throws ReplyHandlerException;    //262";

    void RPL_STATSLINKINFO(String reply) throws ReplyHandlerException;    //211";
    void RPL_STATSCOMMANDS(String reply) throws ReplyHandlerException;    //212";
    void RPL_ENDOFSTATS(String reply) throws ReplyHandlerException;    //219";
    void RPL_STATSUPTIME(String reply) throws ReplyHandlerException;    //242";
    void RPL_STATSOLINE(String reply) throws ReplyHandlerException;    //243";

    void RPL_UMODEIS(String reply) throws ReplyHandlerException;    //221";

    void RPL_SERVLIST(String reply) throws ReplyHandlerException;    //= "234";
    void RPL_SERVLISTEND(String reply) throws ReplyHandlerException;    //235";

    void RPL_LUSERCLIENT(String reply) throws ReplyHandlerException;    //251";
    void RPL_LUSEROP(String reply) throws ReplyHandlerException;    //252";
    void RPL_LUSERUNKNOWN(String reply) throws ReplyHandlerException;    //253";
    void RPL_LUSERCHANNELS(String reply) throws ReplyHandlerException;    //254";
    void RPL_LUSERME(String reply) throws ReplyHandlerException;    //255";

    void RPL_ADMINME(String reply) throws ReplyHandlerException;    //256";
    void RPL_ADMINLOC1(String reply) throws ReplyHandlerException;    //257";
    void RPL_ADMINLOC2(String reply) throws ReplyHandlerException;    //258";
    void RPL_ADMINEMAIL(String reply) throws ReplyHandlerException;    //259";

    void RPL_TRYAGAIN(String reply) throws ReplyHandlerException;    //263";
    
    // 5.2 Error Replies
    
    void ERR_NOSUCHNICK(String reply) throws ReplyHandlerException;    //401";
    void ERR_NOSUCHSERVER(String reply) throws ReplyHandlerException;    //402";
    void ERR_NOSUCHCHANNEL(String reply) throws ReplyHandlerException;    //403";
    void ERR_CANNOTSENDTOCHAN(String reply) throws ReplyHandlerException;    //404";
    void ERR_TOOMANYCHANNELS(String reply) throws ReplyHandlerException;    //405";
    void ERR_WASNOSUCHNICK(String reply) throws ReplyHandlerException;    //406";
    void ERR_TOOMANYTARGETS(String reply) throws ReplyHandlerException;    //407";
    void ERR_NOSUCHSERVICE(String reply) throws ReplyHandlerException;    //408";
    void ERR_NOORIGIN(String reply) throws ReplyHandlerException;    //409";
    
    void ERR_NORECIPIENT(String reply) throws ReplyHandlerException;    //411";
    void ERR_NOTEXTTOSEND(String reply) throws ReplyHandlerException;    //412";
    void ERR_NOTOPLEVEL(String reply) throws ReplyHandlerException;    //413";
    void ERR_WILDTOPLEVEL(String reply) throws ReplyHandlerException;    //414";
    void ERR_BADMASK(String reply) throws ReplyHandlerException;    //415";

    void ERR_UNKNOWNCOMMAND(String reply) throws ReplyHandlerException;    //421";
    void ERR_NOMOTD(String reply) throws ReplyHandlerException;    //422";
    void ERR_NOADMININFO(String reply) throws ReplyHandlerException;    //423";
    void ERR_FILEERROR(String reply) throws ReplyHandlerException;    //424";

    void ERR_NONICKNAMEGIVEN(String reply) throws ReplyHandlerException;    //431";
    void ERR_ERRONEUSNICKNAME(String reply) throws ReplyHandlerException;    //432";
    void ERR_NICKNAMEINUSE(String reply) throws ReplyHandlerException;    //433";

    void ERR_NICKCOLLISION(String reply) throws ReplyHandlerException;    //436";
    void ERR_UNAVAILRESOURCE(String reply) throws ReplyHandlerException;    //437";

    void ERR_USERNOTINCHANNEL(String reply) throws ReplyHandlerException;    //441";
    void ERR_NOTONCHANNEL(String reply) throws ReplyHandlerException;    //442";
    void ERR_USERONCHANNEL(String reply) throws ReplyHandlerException;    //443";
    void ERR_NOLOGIN(String reply) throws ReplyHandlerException;    //444";
    void ERR_SUMMONDISABLED(String reply) throws ReplyHandlerException;    //445";
    void ERR_USERSDISABLED(String reply) throws ReplyHandlerException;    //446";

    void ERR_NOTREGISTERED(String reply) throws ReplyHandlerException;    //451";

    void ERR_NEEDMOREPARAMS(String reply) throws ReplyHandlerException;    //461";
    void ERR_ALREADYREGISTERED(String reply) throws ReplyHandlerException;    //462";
    void ERR_NOPERMFORHOST(String reply) throws ReplyHandlerException;    //463";
    void ERR_PASSWDMISMATCH(String reply) throws ReplyHandlerException;    //464";
    void ERR_YOUREBANNEDCREEP(String reply) throws ReplyHandlerException;    //465";
    void ERR_YOUWILLBEBANNED(String reply) throws ReplyHandlerException;    //466";
    void ERR_KEYSET(String reply) throws ReplyHandlerException;    //467";

    void ERR_CHANNELISFULL(String reply) throws ReplyHandlerException;    //471";
    void ERR_UNKNOWNMODE(String reply) throws ReplyHandlerException;    //472";
    void ERR_INVITEONLYCHAN(String reply) throws ReplyHandlerException;    //473";
    void ERR_BANNEDFROMCHAN(String reply) throws ReplyHandlerException;    //474";
    void ERR_BADCHANNELKEY(String reply) throws ReplyHandlerException;    //475";
    void ERR_BADCHANMASK(String reply) throws ReplyHandlerException;    //476";
    void ERR_NOCHANMODES(String reply) throws ReplyHandlerException;    //477";
    void ERR_BANLISTFULL(String reply) throws ReplyHandlerException;    //478";

    void ERR_NOPRIVILEGES(String reply) throws ReplyHandlerException;    //481";
    void ERR_CHANOPRIVSNEEDED(String reply) throws ReplyHandlerException;    //482";
    void ERR_CANTKILLSERVER(String reply) throws ReplyHandlerException;    //483";
    void ERR_RESTRICTED(String reply) throws ReplyHandlerException;    //484";
    void ERR_UNIQOPPRIVSNEEDED(String reply) throws ReplyHandlerException;    //485";

    void ERR_NOOPERHOST(String reply) throws ReplyHandlerException;    //491";

    void ERR_UMODEUNKNOWNFLAG(String reply) throws ReplyHandlerException;    //501";
    void ERR_USERSDONTMATCH(String reply) throws ReplyHandlerException;    //502";
    
    // 5.3 Reserved numerics
    
    void RPL_SERVICEINFO(String reply) throws ReplyHandlerException;    //231";
    void RPL_ENDOFSERVICES(String reply) throws ReplyHandlerException;    //232";
    void RPL_SERVICE(String reply) throws ReplyHandlerException;    //233";

    void RPL_NONE(String reply) throws ReplyHandlerException;    //300";

    void RPL_WHOISCHANOP(String reply) throws ReplyHandlerException;    //316";

    void RPL_KILLDONE(String reply) throws ReplyHandlerException;    //361";
    void RPL_CLOSING(String reply) throws ReplyHandlerException;    //362";
    void RPL_CLOSEEND(String reply) throws ReplyHandlerException;    //363";

    void RPL_INFOSTART(String reply) throws ReplyHandlerException;    //373";

    void RPL_MYPORTIS(String reply) throws ReplyHandlerException;    //384";

    void RPL_STATSCLINE(String reply) throws ReplyHandlerException;    //213";
    void RPL_STATSNLINE(String reply) throws ReplyHandlerException;    //214";
    void RPL_STATSILINE(String reply) throws ReplyHandlerException;    //215";
    void RPL_STATSKLINE(String reply) throws ReplyHandlerException;    //216";
    void RPL_STATSQLINE(String reply) throws ReplyHandlerException;    //217";
    void RPL_STATSYLINE(String reply) throws ReplyHandlerException;    //218";

    void RPL_STATSVLINE(String reply) throws ReplyHandlerException;    //240";
    void RPL_STATSLLINE(String reply) throws ReplyHandlerException;    //241";

    void RPL_STATSHLINE(String reply) throws ReplyHandlerException;    //244";
    void RPL_STATSSLINE(String reply) throws ReplyHandlerException;    //245";
    void RPL_STATSPING(String reply) throws ReplyHandlerException;    //246";
    void RPL_STATSBLINE(String reply) throws ReplyHandlerException;    //247";

    void RPL_STATSDLINE(String reply) throws ReplyHandlerException;    //250";
}

